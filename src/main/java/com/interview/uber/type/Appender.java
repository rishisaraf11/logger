package com.interview.uber.type;

public class Appender {
    private String type;
    private Level level;
    private String fileImolementation;

    public Appender(String type, Level levels) {
        this.type = type;
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public Level getLevel() {
        return level;
    }
}
