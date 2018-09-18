package com.interview.uber;

import com.interview.uber.type.Level;

public interface Logger {

    public void log(Level level, String msg, String[] params);
}
