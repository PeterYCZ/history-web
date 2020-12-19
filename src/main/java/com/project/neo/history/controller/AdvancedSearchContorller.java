package com.project.neo.history.controller;

import com.project.neo.history.entity.AdvancedSearchDTO;
import com.project.neo.history.entity.AdvancedSearchVO;
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
    public AdvancedSearchVO listEvents(@RequestBody AdvancedSearchDTO advancedSearchDTO) {
        String name = advancedSearchDTO.getEventName();
        String placeName = advancedSearchDTO.getPlaceName();
        String personName = advancedSearchDTO.getPersonName();
        String timeRangeName = advancedSearchDTO.getTimeRangeName();
        AdvancedSearchVO advancedSearchVO = new AdvancedSearchVO(advancedSearchDTO);
        if(name == null) {
           if(placeName == null) {
               advancedSearchVO.setEventList(eventRepository.findAllByPersonsNameAndTimeQuantumsName(personName,timeRangeName));
           }else if(personName == null) {
               advancedSearchVO.setEventList(eventRepository.findAllByTimeQuantumsNameAndPlacesName(timeRangeName,placeName));
           }else if(timeRangeName == null) {
               advancedSearchVO.setEventList(eventRepository.findAllByPersonsNameAndPlacesName(personName,placeName));
           } else {
               advancedSearchVO.setEventList(eventRepository.findAllByPersonsNameAndPlacesNameAndTimeQuantumsName(personName,placeName,timeRangeName));
           }
        }else if(placeName == null) {
            if(personName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByNameAndTimeQuantumsName(name,timeRangeName));
            }else if(timeRangeName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByNameAndPersonsName(name,personName));
            } else {
                advancedSearchVO.setEventList(eventRepository.findAllByNameAndPersonsNameAndTimeQuantumsName (name,personName,timeRangeName));
            }
        }else if(personName == null) {
            if(timeRangeName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByNameAndPlacesName(name,placeName));
            } else {
                advancedSearchVO.setEventList(eventRepository.findAllByNameAndPlacesNameAndTimeQuantumsName(name,placeName,timeRangeName));
            }
        }else if(timeRangeName == null) {
            advancedSearchVO.setEventList(eventRepository.findAllByNameAndPlacesNameAndPersonsName(name,placeName,personName));
        }else {
            advancedSearchVO.setEventList(eventRepository.findAllByNameAndPlacesNameAndPersonsNameAndTimeQuantumsName(name,placeName,personName,timeRangeName));
        }
        return advancedSearchVO;
    }

}
