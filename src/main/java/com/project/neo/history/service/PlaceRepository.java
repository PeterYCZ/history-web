package com.project.neo.history.service;

import com.project.neo.history.entity.Countryman;
import com.project.neo.history.entity.PersonDetail;
import com.project.neo.history.entity.Place;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface PlaceRepository extends Repository<Place, String> {

    @Query("MATCH (p:Person)-[:NATIVEPLACE]->(place:Place{name:$name})\n" +
            "RETURN place,collect (p) as countrymanList")
    Countryman getCountrymanList(String name);

}
