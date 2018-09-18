package com.interview.uber.exception;

public class AppenderException extends Exception {

    public AppenderException(String appender, String message) {
        super(appender + " : " + message);
    }

}
