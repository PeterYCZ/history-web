package com.project.neo.history.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Person {

    @Id
    private final String name;

    private Integer birthyear;
    private Integer deathyear;

    private String portrait;

    private String lifeStory;

    public Person(String name, Integer birthyear, Integer deathyear, String portrait, String lifeStory) {
        this.name = name;
        this.birthyear = birthyear;
        this.deathyear = deathyear;
        this.portrait = portrait;
        this.lifeStory = lifeStory;
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

    public String getPortrait() {
        return portrait;
    }

    public String getLifeStory() {
        return lifeStory;
    }
}
