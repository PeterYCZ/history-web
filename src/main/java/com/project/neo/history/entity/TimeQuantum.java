package com.project.neo.history.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class TimeQuantum implements GraphNode{

    @Id
    private String name;
    private String realname;
    private Integer endYear;
    private Integer startYear;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRealname() {
        return realname;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
