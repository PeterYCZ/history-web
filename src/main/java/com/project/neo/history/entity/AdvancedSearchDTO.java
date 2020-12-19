package com.project.neo.history.entity;

public class AdvancedSearchDTO {

    private String personName;
    private String placeName;
    private String timeRangeName;
    private String eventName;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getTimeRangeName() {
        return timeRangeName;
    }

    public void setTimeRangeName(String timeRangeName) {
        this.timeRangeName = timeRangeName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
