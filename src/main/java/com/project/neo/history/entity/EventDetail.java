package com.project.neo.history.entity;

public class EventDetail {

    private final String name;
    private final String describe;

    public EventDetail(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }
}
