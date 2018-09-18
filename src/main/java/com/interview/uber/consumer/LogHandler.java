package com.interview.uber.consumer;

import com.interview.uber.exception.AppenderException;

public interface LogHandler {

    public void log(String msg) throws AppenderException;
}
