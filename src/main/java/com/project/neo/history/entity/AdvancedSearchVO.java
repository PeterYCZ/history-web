package com.project.neo.history.entity;

import java.util.List;

public class AdvancedSearchVO {

    private final String personName;
    private final String placeName;
    private final String timeRangeName;
    private final String eventName;

    public AdvancedSearchVO(AdvancedSearchDTO advancedSearchDTO) {
        this.personName = advancedSearchDTO.getPersonName();
        this.placeName = advancedSearchDTO.getPlaceName();
        this.timeRangeName = advancedSearchDTO.getTimeRangeName();
        this.eventName = advancedSearchDTO.getEventName();
    }

    private List<Event> eventList;

    public String getPersonName() {
        return personName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getTimeRangeName() {
        return timeRangeName;
    }

    public String getEventName() {
        return eventName;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
