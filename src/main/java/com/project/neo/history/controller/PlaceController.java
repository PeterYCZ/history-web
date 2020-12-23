package com.project.neo.history.controller;

import com.project.neo.history.entity.*;
import com.project.neo.history.service.EventRepository;
import com.project.neo.history.service.PlaceRepository;
import com.project.neo.history.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaceController {

    private static final SnowflakeIdWorker idWorker = new SnowflakeIdWorker(2, 0);

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/api/v1/getPlace/{name}")
    public GraphDataVO  getPlaceEventsByName(@PathVariable String name) {
        GraphDataVO graphDataVO = new GraphDataVO();
        List<Place> places = placeRepository.findAllByRealname(name);
        List<PlaceEvents> placeEvents = new ArrayList<>();
        for(Place place : places) {
            List<Event> events = eventRepository.findAllByPlacesName(place.getName());
            PlaceEvents placeEvent = new PlaceEvents(place.getName(),place.getRealname(), place.getDescribe());
            placeEvent.setEventList(events);
            placeEvents.add(placeEvent);
        }
        for(PlaceEvents placeEvent : placeEvents) {
            Place place = Place.convert(placeEvent);
            graphDataVO.addData(place);
            GraphDataVO.addFromEvent(graphDataVO,placeEvent.getEventList());
        }

        return graphDataVO;
    }

    @PostMapping("/api/v1/insertPlace")
    public Place insertPerson(@RequestBody Place place){
        String name = String.valueOf(idWorker.nextId());
        String realname = place.getName();
        String describe = place.getDescribe();
        return placeRepository.inertPlace(name,realname,describe);
    }

}
