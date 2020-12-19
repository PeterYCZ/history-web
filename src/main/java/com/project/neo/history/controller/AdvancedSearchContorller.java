package com.project.neo.history.controller;

import com.project.neo.history.entity.AdvancedSearchDTO;
import com.project.neo.history.entity.Event;
import com.project.neo.history.service.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdvancedSearchContorller {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/api/v1/advancedsearch/")
    public List<Event> listEvents(@RequestBody AdvancedSearchDTO advancedSearchDTO) {
        String name = advancedSearchDTO.getEventName();
        String placeName = advancedSearchDTO.getPlaceName();
        String personName = advancedSearchDTO.getPersonName();
        String timeRangeName = advancedSearchDTO.getTimeRangeName();
        if(name == null) {
           if(placeName == null) {
                return eventRepository.findAllByPersonsNameAndTimeQuantumsName(personName,timeRangeName);
           }else if(personName == null) {
                return eventRepository.findAllByTimeQuantumsNameAndPlacesName(timeRangeName,placeName);
           }else if(timeRangeName == null) {
                return eventRepository.findAllByPersonsNameAndPlacesName(personName,placeName);
           } else {
                return eventRepository.findAllByPersonsNameAndPlacesNameAndTimeQuantumsName(personName,placeName,timeRangeName);
           }
        }else if(placeName == null) {
            if(personName == null) {
                return eventRepository.findAllByNameAndTimeQuantumsName(name,timeRangeName);
            }else if(timeRangeName == null) {
                return eventRepository.findAllByNameAndPersonsName(name,personName);
            } else {
                return eventRepository.findAllByNameAndPersonsNameAndTimeQuantumsName (name,personName,timeRangeName);
            }
        }else if(personName == null) {
            if(timeRangeName == null) {
                return eventRepository.findAllByNameAndPlacesName(name,placeName);
            } else {
                return eventRepository.findAllByNameAndPlacesNameAndTimeQuantumsName(name,placeName,timeRangeName);
            }
        }else if(timeRangeName == null) {
            return eventRepository.findAllByNameAndPlacesNameAndPersonsName(name,placeName,personName);
        }else {
            return eventRepository.findAllByNameAndPlacesNameAndPersonsNameAndTimeQuantumsName(name,placeName,personName,timeRangeName);
        }
    }

}
