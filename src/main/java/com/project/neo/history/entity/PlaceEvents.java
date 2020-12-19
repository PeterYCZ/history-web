package com.project.neo.history.entity;

import org.springframework.data.neo4j.core.schema.Id;

import java.util.List;

public class PlaceEvents {

    private final String name;

    private final String describe;

    private List<Event> eventList;

    public PlaceEvents(String name, String describe) {
        this.name = name;
        this.describe = describe;
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
