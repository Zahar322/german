package com.company.model;

import com.company.service.SubjectService;
import com.company.service.SubjectServiceImpl;
import com.company.util.Converter;
import com.company.util.SubjectComparator;

import java.util.List;

public class UnluckyVassal {

    public void printReportForKing(List<String> pollResults) {
        SubjectComparator subjectComparator = new SubjectComparator();
        SubjectService subjectService = new SubjectServiceImpl(subjectComparator);
        Subject subject = subjectService.createChain(Converter.convert(pollResults));
        System.out.println(subject.getSubordinateName(0));
    }
}
