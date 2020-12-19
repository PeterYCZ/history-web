package com.project.neo.history.service;

import com.project.neo.history.entity.Event;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EventRepository extends Repository<Event, String> {

    List<Event> findAllByPersonsName(String name);

    List<Event> findAllByTimeQuantumsName(String name);

    List<Event> findAllByPlacesName(String name);
}
