package com.project.neo.history.service;

import com.project.neo.history.entity.Event;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface RelationshipRepository extends Repository<Event, String> {

    @Query("Match (p:Person{name:$personName}),(e:Event{name:$eventName})\n" +
            "Create (p)-[:DONE]->(e)\n" +
            "return e")
    Event personToEvent(String personName,String eventName);

    @Query("Match (p:Place{name:$placeName}),(e:Event{name:$eventName})\n" +
            "Create (p)-[:HappendedAtT]->(e)\n" +
            "return e")
    Event placeToEvent(String placeName,String eventName);

    @Query("Match (t:TimeQuantum{name:$timeName}),(e:Event{name:$eventName})\n" +
            "Create (t)-[:HappenedIn]->(e)\n" +
            "return e")
    Event timeToEvent(String timeName,String eventName);

}
