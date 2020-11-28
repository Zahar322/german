package com.company.model;

import java.util.List;

public class Subordinate {
    private String name;
    private List<Subordinate> subordinates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subordinate> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Subordinate> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        if (subordinates != null) {
            for (Subordinate subordinate : subordinates) {
                stringBuilder.append(" : ").append(subordinate.toString());
            }
        }
        return name + stringBuilder.toString();
    }
}
