package com.project.neo.history.entity;

import java.util.ArrayList;
import java.util.List;

public class PersonDetail {

    private final String name;

    private final String realname;

    private final Integer birthyear;
    private final Integer deathyear;

    private final String portrait;

    private final String lifeStory;

    private final List<Person> partner;

    private List<Event> events = new ArrayList<>();

    public PersonDetail(String name,String realname, Integer birthyear, Integer deathyear, String portrait, String lifeStory, List<Person> partner) {
        this.name = name;
        this.realname = realname;
        this.birthyear = birthyear;
        this.deathyear = deathyear;
        this.portrait = portrait;
        this.lifeStory = lifeStory;
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthyear() {
        return birthyear;
    }

    public Integer getDeathyear() {
        return deathyear;
    }

    public List<Person> getPartner() {
        return partner;
    }

    public String getLifeStory() {
        return lifeStory;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public String getRealname() {
        return realname;
    }
}
