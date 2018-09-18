package com.interview.uber.type;

public enum Level {
    INFO(2),DEBUG(1);

    private int priority;

    Level(int priority) {
        this.priority = priority;
    }
}
