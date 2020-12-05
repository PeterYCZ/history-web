package com.project.neo.history.entity;

import java.util.List;

public class Countryman {

    private final String name;

    private final String describe;

    private final List<Person> countrymanList;

    public Countryman(String name, String describe, List<Person> countrymanList) {
        this.name = name;
        this.describe = describe;
        this.countrymanList = countrymanList;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public List<Person> getCountrymanList() {
        return countrymanList;
    }
}
