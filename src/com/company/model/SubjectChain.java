package com.company.model;

public class SubjectChain {

    private String name;
    private SubjectChain subjectChain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubjectChain getSubjectChain() {
        return subjectChain;
    }

    public void setSubjectChain(SubjectChain subjectChain) {
        this.subjectChain = subjectChain;
    }
}
