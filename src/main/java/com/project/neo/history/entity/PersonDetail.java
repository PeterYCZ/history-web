package com.project.neo.history.entity;

import java.util.List;

public class PersonDetail {

    private final String name;

    private final Integer birthyear;
    private final Integer deathyear;

    private final String portrait;

    private final String lifeStory;

    private final List<Person> partner;

    public PersonDetail(String name, Integer birthyear, Integer deathyear, String portrait, String lifeStory, List<Person> partner) {
        this.name = name;
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

    public String getportrait() {
        return portrait;
    }

    public String getLifeStory() {
        return lifeStory;
    }
}
