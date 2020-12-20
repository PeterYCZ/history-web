package com.project.neo.history.entity;

public class Link {

    private String source;
    private String target;
    private String name;
    private String des;

    public Link(String source, String target,String name,String des) {
        this.source = source;
        this.target = target;
        this.name = name;
        this.name = des;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean equals(Link link) {
        if(link.getName().equals(this.name) && link.getSource().equals(this.source) && link.getTarget().equals(this.target)) {
            return true;
        }
        return false;
    }
}
