package com.project.neo.history.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Event implements GraphNode{

    @Id
    private String name;
    private String realname;
    private String describe;

    @JsonIgnore
    @Relationship(type = "HappenedAt", direction = Relationship.Direction.OUTGOING)
    private List<Place> places = new ArrayList<>();

    @JsonIgnore
    @Relationship(type = "HappenedIn", direction = Relationship.Direction.OUTGOING)
    private List<TimeQuantum> timeQuantums = new ArrayList<>();

    @JsonIgnore
    @Relationship(type = "DONE", direction = Relationship.Direction.INCOMING)
    private List<Person> persons = new ArrayList<>();

    public Event(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<TimeQuantum> getTimeQuantums() {
        return timeQuantums;
    }

    public void setTimeQuantums(List<TimeQuantum> timeQuantums) {
        this.timeQuantums = timeQuantums;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return this.name + " " + this.describe;
    }
}
