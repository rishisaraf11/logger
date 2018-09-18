package com.interview.uber.log.initializer;

import com.interview.uber.log.LoggingImpl;
import com.interview.uber.type.Level;

public class LoggingStartupTest {

    public static void main(String[] args) {
        LoggingImpl logger = new LoggingImpl();
        String[] msgArgs = new String[1];
         for (int i=0;i<10;i++) {
             msgArgs[0] = i + "";
             logger.log(Level.INFO, "This is test message %s", msgArgs);
         }
    }

}