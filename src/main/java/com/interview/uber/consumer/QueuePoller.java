package com.interview.uber.consumer;

import java.util.concurrent.LinkedBlockingQueue;

import com.interview.uber.exception.AppenderException;
import com.interview.uber.type.Event;

public class QueuePoller implements Runnable {
    private LinkedBlockingQueue linkedBlockingQueue;
    private LogHandler logHandler;

    public QueuePoller(LinkedBlockingQueue linkedBlockingQueue, LogHandler logHandler) {
        this.linkedBlockingQueue = linkedBlockingQueue;
        this.logHandler = logHandler;
    }

    public void run() {
        while (true) {
            if (!linkedBlockingQueue.isEmpty()) {
                final Event msg = (Event) linkedBlockingQueue.poll();
                try {
                    logHandler.log(msg.getMsg());
                } catch (AppenderException e) {
                    System.out.println("Message cannot be logged" + msg.getMsg());
                }
            }
        }
    }
}
