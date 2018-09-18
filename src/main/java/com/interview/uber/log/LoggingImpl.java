package com.interview.uber.log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.interview.uber.Logger;
import com.interview.uber.consumer.FileLogHandler;
import com.interview.uber.consumer.QueuePoller;
import com.interview.uber.exception.AppenderException;
import com.interview.uber.prodcuer.LogMessageProducer;
import com.interview.uber.type.Appender;
import com.interview.uber.type.Event;
import com.interview.uber.type.Level;

public class LoggingImpl implements Logger {
    private LogMessageProducer logMessageProducer;
    private static List<Appender> appenders = new ArrayList<Appender>();

    static {
        appenders.add(new Appender("file", Level.INFO));
    }

    public LoggingImpl() {

        logMessageProducer = new LogMessageProducer();

        for (int i = 0; i < appenders.size(); i++) {
            final Appender appender = appenders.get(i);
            if (appender.getType().equals("file")) {
                final LinkedBlockingQueue<Event> fileQueue = new LinkedBlockingQueue<>();
                logMessageProducer.addConsumerQueue("file", fileQueue);
                try {
                    FileLogHandler handler = new FileLogHandler();
                    QueuePoller fileQueuePoller = new QueuePoller(fileQueue, handler);
                    final Thread consumerT = new Thread(fileQueuePoller);
                    consumerT.start();
                } catch (AppenderException e) {
                    System.out.println("ERROR!!! File Appender now intialized");
                }

            }
        }

    }

    public void log(Level level, String msg, String[] params) {
        final String finalMessage = String.format(msg, params);
        final Event event = new Event(finalMessage, level);
        logMessageProducer.produce(event);

    }
}
