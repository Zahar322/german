package com.company.model;

import java.util.List;

public class Subject {
    private String name;
    private List<Subject> subjects;

    public String getName() {
        return name;
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }


    public String getSubordinateName(int step) {
        StringBuilder stringBuilder = new StringBuilder();
        if (subjects != null) {
            step++;
            for (Subject subject : subjects) {
                stringBuilder.append("\n");
                for (int i = 0; i < step; i++) {
                    stringBuilder.append("  ");
                }
                stringBuilder.append(subject.getSubordinateName(step));
            }
        }
        return name + stringBuilder.toString();
    }

    @Override
    public String toString() {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        if (subjects != null) {
            for (Subject subject : subjects) {
                stringBuilder.append("\n");
                stringBuilder.append(subject.toString());
            }
        }
        return name + stringBuilder.toString();
    }

}
