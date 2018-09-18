package com.interview.uber.consumer;

import java.io.FileWriter;
import java.io.IOException;

import com.interview.uber.exception.AppenderException;

public class FileLogHandler implements LogHandler {

    private FileWriter writer;

    public FileLogHandler() throws AppenderException {
        try {
            writer = new FileWriter("/tmp/mylog.log", true);
        } catch (IOException e) {
            throw new AppenderException("File", "Not able to register");
        }
    }

    public void log(String msg) throws AppenderException {
        try {
            writer.append(msg);
            writer.flush();
        } catch (IOException e) {
            new AppenderException("File", "Not able to log mesage");
        }

    }
}
