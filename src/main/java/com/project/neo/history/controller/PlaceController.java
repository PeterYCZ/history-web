package com.project.neo.history.controller;

import com.project.neo.history.entity.Countryman;
import com.project.neo.history.entity.Event;
import com.project.neo.history.entity.Place;
import com.project.neo.history.entity.PlaceEvents;
import com.project.neo.history.service.EventRepository;
import com.project.neo.history.service.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/api/v1/getPlace/{name}")
    public PlaceEvents getPlaceEventsByName(@PathVariable String name) {
        Place place = placeRepository.findAllByName(name);
        List<Event> events = eventRepository.findAllByPlacesName(name);
        PlaceEvents placeEvents = new PlaceEvents(place.getName(),place.getDescribe());
        placeEvents.setEventList(events);
        return placeEvents;
    }

}
