package com.project.neo.history.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Place implements GraphNode{

    @Id
    private final String name;

    private String realname;

    private String describe;

    public Place(String name,String realname, String describe) {
        this.name = name;
        this.realname = realname;
        this.describe = describe;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    public static Place convert(PlaceEvents placeEvents) {
        return new Place(placeEvents.getName(),placeEvents.getRealname(), placeEvents.getDescribe()) ;
    }

}
