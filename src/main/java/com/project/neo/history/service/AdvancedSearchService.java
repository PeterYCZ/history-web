package com.project.neo.history.service;

import com.project.neo.history.entity.AdvancedSearchDTO;
import com.project.neo.history.entity.AdvancedSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdvancedSearchService {

    @Autowired
    private EventRepository eventRepository;

    public AdvancedSearchVO listEvents(AdvancedSearchDTO advancedSearchDTO) {
        String name = advancedSearchDTO.getEventName().equals("")?null:advancedSearchDTO.getEventName();
        String placeName = advancedSearchDTO.getPlaceName().equals("")?null:advancedSearchDTO.getPlaceName();
        String personName = advancedSearchDTO.getPersonName().equals("")?null:advancedSearchDTO.getPersonName();
        String timeRangeName = advancedSearchDTO.getTimeRangeName().equals("")?null:advancedSearchDTO.getTimeRangeName();
        AdvancedSearchVO advancedSearchVO = new AdvancedSearchVO(advancedSearchDTO);
        if(name == null) {
            if(placeName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByPersonsRealnameAndTimeQuantumsName(personName,timeRangeName));
            }else if(personName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByTimeQuantumsNameAndPlacesRealname(timeRangeName,placeName));
            }else if(timeRangeName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByPersonsRealnameAndPlacesRealname(personName,placeName));
            } else {
                advancedSearchVO.setEventList(eventRepository.findAllByPersonsRealnameAndPlacesRealnameAndTimeQuantumsName(personName,placeName,timeRangeName));
            }
        }else if(placeName == null) {
            if(personName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByRealnameAndTimeQuantumsName(name,timeRangeName));
            }else if(timeRangeName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByRealnameAndPersonsRealname(name,personName));
            } else {
                advancedSearchVO.setEventList(eventRepository.findAllByRealnameAndPersonsRealnameAndTimeQuantumsName (name,personName,timeRangeName));
            }
        }else if(personName == null) {
            if(timeRangeName == null) {
                advancedSearchVO.setEventList(eventRepository.findAllByRealnameAndPlacesRealname(name,placeName));
            } else {
                advancedSearchVO.setEventList(eventRepository.findAllByRealnameAndPlacesRealnameAndTimeQuantumsName(name,placeName,timeRangeName));
            }
        }else if(timeRangeName == null) {
            advancedSearchVO.setEventList(eventRepository.findAllByRealnameAndPlacesRealnameAndPersonsRealname(name,placeName,personName));
        }else {
            advancedSearchVO.setEventList(eventRepository.findAllByRealnameAndPlacesRealnameAndPersonsRealnameAndTimeQuantumsName(name,placeName,personName,timeRangeName));
        }
        return advancedSearchVO;
    }

}
