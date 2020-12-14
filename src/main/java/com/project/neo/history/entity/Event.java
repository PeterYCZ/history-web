package com.project.neo.history.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Event {

    @Id
    private String name;
    private String describe;

    @Relationship(type = "HappenedAt", direction = Relationship.Direction.OUTGOING)
    private List<Place> places = new ArrayList<>();

    @Relationship(type = "HappenedIn", direction = Relationship.Direction.OUTGOING)
    private List<TimeQuantum> timeQuantums = new ArrayList<>();

    @Relationship(type = "DONE", direction = Relationship.Direction.INCOMING)
    private List<Person> persons = new ArrayList<>();

    public Event(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
