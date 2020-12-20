package com.project.neo.history.service;

import com.project.neo.history.entity.Countryman;
import com.project.neo.history.entity.Place;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PlaceRepository extends Repository<Place, String> {

    @Query("MATCH (p:Person)-[:1**3]->(place:Place{name:$name})\n" +
            "RETURN place,collect (p) as countrymanList")
    Countryman getCountrymanList(String name);

    List<Place> findAllByRealname(String realname);

    @Query("CREATE (place:Place{name: $name, realname: $realname," +
            "describe: $describe})\n" +
            "RETURN place")
    Place inertPlace(String name, String realname, String describe);


}
