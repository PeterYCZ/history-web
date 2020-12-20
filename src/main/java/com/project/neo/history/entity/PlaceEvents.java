package com.project.neo.history.entity;

import org.springframework.data.neo4j.core.schema.Id;

import java.util.List;

public class PlaceEvents {

    private final String name;

    private final String describe;

    private String realname;

    private List<Event> eventList;

    public PlaceEvents(String name,String realname, String describe) {
        this.name = name;
        this.realname = realname;
        this.describe = describe;
    }

    public String getRealname() {
        return realname;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
