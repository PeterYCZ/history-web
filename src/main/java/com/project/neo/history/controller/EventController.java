package com.project.neo.history.controller;

import com.project.neo.history.entity.AdvancedSearchDTO;
import com.project.neo.history.entity.Event;
import com.project.neo.history.service.EventRepository;
import com.project.neo.history.service.RelationshipRepository;
import com.project.neo.history.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

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

}
