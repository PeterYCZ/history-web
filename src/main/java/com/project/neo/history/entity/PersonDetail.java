package com.project.neo.history.entity;

import java.util.List;

public class PersonDetail {

    private final String name;

    private final Integer birthyear;
    private final Integer deathyear;

    private final List<Person> partner;

    public PersonDetail(String name, Integer birthyear, Integer deathyear, List<Person> partner) {
        this.name = name;
        this.birthyear = birthyear;
        this.deathyear = deathyear;
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
}
