package com.project.neo.history.service;

import com.project.neo.history.entity.Event;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EventRepository extends Repository<Event, String> {

    List<Event> findAllByPersonsName(String name);

    List<Event> findAllByTimeQuantumsName(String name);

    List<Event> findAllByPlacesName(String name);

    List<Event> findAllByNameAndPlacesName(String name,String placeName);

    List<Event> findAllByNameAndPersonsName(String name,String placeName);

    List<Event> findAllByNameAndTimeQuantumsName(String name,String placeName);

    List<Event> findAllByPersonsNameAndPlacesName(String personName,String placeName);

    List<Event> findAllByPersonsNameAndTimeQuantumsName(String personName,String timeQuantumsName);

    List<Event> findAllByTimeQuantumsNameAndPlacesName(String timeQuantumsName,String placeName);

    List<Event> findAllByNameAndPlacesNameAndPersonsName(String name,String placeName,String personName);

    List<Event> findAllByNameAndPlacesNameAndTimeQuantumsName(String name,String placeName,String timeQuantumsName);

    List<Event> findAllByNameAndPersonsNameAndTimeQuantumsName(String name,String personName,String timeQuantumsName);

    List<Event> findAllByPersonsNameAndPlacesNameAndTimeQuantumsName(String personName,String placeName,String timeQuantumsName);

    List<Event> findAllByNameAndPlacesNameAndPersonsNameAndTimeQuantumsName(String name,String placeName,String personName,String timeQuantumsName);


}
