package com.project.neo.history.service;

import com.project.neo.history.entity.Event;
import com.project.neo.history.entity.Place;
import com.project.neo.history.entity.TimeQuantum;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EventRepository extends Repository<Event, String> {

    List<Event> findAll();

    @Query("CREATE (event:Event{name: $name, realname: $realname," +
            "describe: $describe})\n" +
            "RETURN event")
    Event inertEvent(String name, String realname, String describe);

    List<Event> findAllByPersonsName (String name);

    List<Event> findAllByPersonsRealname (String name);

    List<Event> findAllByTimeQuantumsName(String name);

    List<Event> findAllByPlacesName(String name);

    List<Event> findAllByPlacesRealname(String name);

    List<Event> findAllByRealnameAndPlacesRealname(String name,String placeName);

    List<Event> findAllByRealnameAndPersonsRealname(String name,String placeName);

    List<Event> findAllByRealnameAndTimeQuantumsName(String name,String placeName);

    List<Event> findAllByPersonsRealnameAndPlacesRealname(String personName,String placeName);

    List<Event> findAllByPersonsRealnameAndTimeQuantumsName(String personName,String timeQuantumsName);

    List<Event> findAllByTimeQuantumsNameAndPlacesRealname(String timeQuantumsName,String placeName);

    List<Event> findAllByRealnameAndPlacesRealnameAndPersonsRealname(String name,String placeName,String personName);

    List<Event> findAllByRealnameAndPlacesRealnameAndTimeQuantumsName(String name,String placeName,String timeQuantumsName);

    List<Event> findAllByRealnameAndPersonsRealnameAndTimeQuantumsName(String name,String personName,String timeQuantumsName);

    List<Event> findAllByPersonsRealnameAndPlacesRealnameAndTimeQuantumsName(String personName,String placeName,String timeQuantumsName);

    List<Event> findAllByRealnameAndPlacesRealnameAndPersonsRealnameAndTimeQuantumsName(String name,String placeName,String personName,String timeQuantumsName);


}
