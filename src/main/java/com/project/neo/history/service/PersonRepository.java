package com.project.neo.history.service;

import com.project.neo.history.entity.Person;
import com.project.neo.history.entity.PersonDetail;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<Person, String> {

    @Query("MATCH (person:Person {name: $name})\n"
            + "OPTIONAL MATCH (person)-[:PARTNER]->(p:Person)\n"
            + "RETURN person,\n"
            + "collect (DISTINCT p) AS partner")
    PersonDetail getDetailsByName(String name);

    @Query("CREATE (person:Person{name: $name," +
            "birthyear:$birthyear,deathyear:$deathyear,portrait:$portrait,lifeStory:$lifeStory})\n" +
            " RETURN person")
    Person inertPerson(String name,Integer birthyear,Integer deathyear,String portrait,String lifeStory);

    @Query("MATCH (husband:Person{name: $husband}),(wife:Person{name: $wife})\n" +
            "CREATE (husband)-[:PARTNER]->(wife),(wife)-[:PARTNER]->(husband)\n" +
            "return husband,collect (wife) as partner")
    PersonDetail createPartner(String husband,String wife);

}
