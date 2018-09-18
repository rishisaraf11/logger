package com.interview.uber.prodcuer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import com.interview.uber.type.Event;

public class LogMessageProducer {
    Map<String, LinkedBlockingQueue<Event>> appenderQueues;

    public LogMessageProducer() {
        appenderQueues = new HashMap<String, LinkedBlockingQueue<Event>>();
    }

    public void addConsumerQueue(String appender, LinkedBlockingQueue<Event> queue) {
        appenderQueues.put(appender, queue);
    }

    public void produce(final Event msg) {
        appenderQueues.forEach((appender, queue) -> {
            try {
                queue.put(msg);
            } catch (InterruptedException e) {
                System.out.println("Not able to send msg to :" + appender);
            }
        });
    }
}
