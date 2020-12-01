package com.company.service;

import com.company.model.SubjectChain;
import com.company.model.Subject;
import com.company.util.SubjectComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectComparator subjectComparator;

    public SubjectServiceImpl(SubjectComparator subjectComparator) {
        this.subjectComparator = subjectComparator;
    }

    @Override
    public Subject createChain(Map<String, List<String>> map) {
        List<SubjectChain> subjectChainLst = new ArrayList<>();
        for (String key : map.keySet()) {
            SubjectChain supers = getParent(key, map.entrySet(), null);
            subjectChainLst.add(supers);
        }
        Subject subject = merge(subjectChainLst);
        return populate(subject, map);
    }

    private Subject populate(Subject subject, Map<String, List<String>> map) {
        if (isNull(subject.getSubjects()) || subject.getSubjects().isEmpty()) {
            return subject;
        }
        for (Subject entrySubject : subject.getSubjects()) {
            List<String> subordinateNames = map.get(entrySubject.getName());
            if (isNull(subordinateNames)) {
                continue;
            }
            List<Subject> subjects = populate(subordinateNames);
            Collections.sort(subjects, subjectComparator);
            entrySubject.setSubjects(subjects);
            populate(entrySubject, map);
        }
        return subject;
    }

    private List<Subject> populate(List<String> subordinateNames) {
        if (nonNull(subordinateNames) && subordinateNames.size() == 1) {
            if (subordinateNames.get(0).equals("")) {
                return Collections.EMPTY_LIST;
            }
        }
        return subordinateNames.stream()
                                .map(Subject::new)
                                .collect(Collectors.toList());
    }

    private SubjectChain getParent(String key, Set<Map.Entry<String, List<String>>> entrySet, SubjectChain chain) {
        SubjectChain subjectChain = new SubjectChain();
        subjectChain.setName(key);
        subjectChain.setSubjectChain(chain);
        String chainKey = entrySet.stream()
                .filter(stringListEntry -> stringListEntry.getValue().contains(key))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(key);
        if (chainKey.equals(key)) {
            return subjectChain;
        } else {
            return getParent(chainKey, entrySet, subjectChain);
        }
    }

    private Subject merge(List<SubjectChain> subjectChains) {
        Subject king = new Subject();
        king.setName("король");
        List<Subject> subjects = subjectChains.stream()
                                            .filter(chain -> isNull(chain.getSubjectChain()))
                                            .map(chain -> new Subject(chain.getName()))
                                            .sorted(subjectComparator)
                                            .collect(Collectors.toList());
        king.setSubjects(subjects);
        return king;
    }
}
