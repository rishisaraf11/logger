package com.interview.uber.type;

public class Event {
    private String msg;
    private Level level;

    public Event(String msg, Level level) {
        this.msg = msg;
        this.level = level;
    }

    public String getMsg() {
        return msg;
    }

    public Level getLevel() {
        return level;
    }


}
