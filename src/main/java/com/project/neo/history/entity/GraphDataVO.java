package com.project.neo.history.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphDataVO<T extends GraphNode,E extends GraphNode> {

    private Set<T> data = new HashSet<>();
    private Set<Link> links = new HashSet<>();

    private static String linkName = "link";
    private Set<String> nameList = new HashSet<>();

    public Set<T> getData() {
        return data;
    }

    public void setData(Set<T> data) {
        this.data = data;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    public void addData(T data) {
        if(this.nameList.contains(data.getName()) == false) {
            this.nameList.add(data.getName());
            this.data.add(data);
        }
    }

    public void addLink(T source,E target,String linkName,String name) {
        Link link = new Link(source.getName(),target.getName(),linkName,name);
        this.links.add(link);
    }

    public static void addFromEvent(GraphDataVO graphDataVO, List<Event> eventList) {
        for(Event event : eventList) {
            graphDataVO.addData(event);
            for(Place place : event.getPlaces()) {
                graphDataVO.addData(place);
                graphDataVO.addLink(event,place,linkName,"HappenedAt");
            }
            for(Person person : event.getPersons()) {
                graphDataVO.addLink(person,event,linkName,"RollIn");
                graphDataVO.addData(person);
            }
            for(TimeQuantum timeQuantum : event.getTimeQuantums()) {
                graphDataVO.addLink(event,timeQuantum,linkName,"HappenedIn");
                graphDataVO.addData(timeQuantum);
            }
        }
    }


}
