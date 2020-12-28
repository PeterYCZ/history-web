package com.project.neo.history.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Person implements GraphNode{

    @Id
    private final String name;

    private String realname;

    private Integer birthyear;
    private Integer deathyear;

    private String portrait;

    @JsonProperty(value = "describe")
    private String lifeStory;

    public Person(String name,String realname, Integer birthyear, Integer deathyear, String portrait, String lifeStory) {
        this.name = name;
        this.realname = realname;
        this.birthyear = birthyear;
        this.deathyear = deathyear;
        this.portrait = portrait;
        this.lifeStory = lifeStory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRealname() {
        return realname;
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

    public static Person convert(PersonDetail personDetail) {
        String name = personDetail.getName();
        String realName = personDetail.getRealname();
        Integer birthyear = personDetail.getBirthyear();
        Integer deathyear = personDetail.getDeathyear();
        String portrait = personDetail.getPortrait();
        String lifeStory = personDetail.getLifeStory();
        return new Person(name,realName,birthyear,deathyear,portrait,lifeStory);
    }


}
