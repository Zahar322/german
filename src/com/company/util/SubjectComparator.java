package com.company.util;

import com.company.model.Subject;

import java.util.Comparator;

public class SubjectComparator implements Comparator<Subject> {

    @Override
    public int compare(Subject subject, Subject comparingSubject) {
        return subject.getName().compareTo(comparingSubject.getName());
    }
}
