package com.company.model;


import java.util.List;

public class PreSubordinate {
    private String name;
    private PreSubordinate subordinates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PreSubordinate getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(PreSubordinate subordinates) {
        this.subordinates = subordinates;
    }

    boolean hasNext() {
        return this.subordinates != null;
    }

    PreSubordinate next() {
        return this.subordinates;
    }

    @Override
    public String toString() {
        return name;
    }
}
