package com.project.neo.history.controller;

import com.project.neo.history.entity.Event;
import com.project.neo.history.entity.TimeQuantum;
import com.project.neo.history.entity.TimeQuantumEvents;
import com.project.neo.history.service.EventRepository;
import com.project.neo.history.service.TimeQuantumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeRangeController {

    @Autowired
    private TimeQuantumRepository timeQuantumRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/api/v1/getTimeRange/{name}")
    public TimeQuantumEvents getTimeQuantumByName(@PathVariable String name){
        TimeQuantum timeQuantum = timeQuantumRepository.findAllByName(name);
        List<Event> events = eventRepository.findAllByTimeQuantumsName(name);
        TimeQuantumEvents timeQuantums = new TimeQuantumEvents();
        timeQuantums.setName(timeQuantum.getName());
        timeQuantums.setStartYear(timeQuantum.getStartYear());
        timeQuantums.setEndYear(timeQuantum.getEndYear());
        timeQuantums.setEventList(events);
        return timeQuantums;
    }

    @GetMapping("/api/v1/getYear/{year}")
    public TimeQuantumEvents getTimeQuantumByYear(@PathVariable String year){
        TimeQuantum timeQuantum = timeQuantumRepository.findByStartYearLessThanEqualAndAndEndYearIsGreaterThanEqual(Integer.valueOf(year),Integer.valueOf(year));
        List<Event> events = eventRepository.findAllByTimeQuantumsName(timeQuantum.getName());
        TimeQuantumEvents timeQuantums = new TimeQuantumEvents();
        timeQuantums.setName(timeQuantum.getName());
        timeQuantums.setStartYear(timeQuantum.getStartYear());
        timeQuantums.setEndYear(timeQuantum.getEndYear());
        timeQuantums.setEventList(events);
        return timeQuantums;
    }

}
