package com.project.neo.history.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Person {

    @Id
    private final String name;

    private Integer birthyear;
    private Integer deathyear;

    public Person(String name, Integer birthyear, Integer deathyear) {
        this.name = name;
        this.birthyear = birthyear;
        this.deathyear = deathyear;
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
}
