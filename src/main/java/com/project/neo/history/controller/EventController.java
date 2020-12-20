package com.project.neo.history.controller;

import com.project.neo.history.entity.*;
import com.project.neo.history.service.*;
import com.project.neo.history.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private TimeQuantumRepository timeQuantumRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RelationshipRepository relationshipRepository;

    private static final SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    @PostMapping("/api/v1/insertEvent")
    public Event insertEvent(@RequestBody Event event){
        String name = String.valueOf(idWorker.nextId());
        String realname = event.getName();
        String describe = event.getDescribe();
        return eventRepository.inertEvent(name,realname,describe);
    }

    @PostMapping("/api/v1/createRelationship")
    public boolean createRelationShip(@RequestBody AdvancedSearchDTO advancedSearchDTO) {
        boolean result = false;
        if(advancedSearchDTO.getPersonName() != null) {
            relationshipRepository.personToEvent(advancedSearchDTO.getPersonName(), advancedSearchDTO.getEventName());
        }
        if(advancedSearchDTO.getPlaceName() != null) {
            relationshipRepository.placeToEvent(advancedSearchDTO.getPlaceName(), advancedSearchDTO.getEventName());
        }
        if(advancedSearchDTO.getTimeRangeName() != null) {
            relationshipRepository.timeToEvent(advancedSearchDTO.getTimeRangeName(), advancedSearchDTO.getEventName());
        }
        result = true;
        return result;
    }

    @GetMapping("/api/v1/listPerson")
    public List<Person> listPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/api/v1/listPlace")
    public List<Place> listPlace() {
        return placeRepository.findAll();
    }

    @GetMapping("/api/v1/listTime")
    public List<TimeQuantum> listTimeQuant() {
        return timeQuantumRepository.findAll();
    }

}
