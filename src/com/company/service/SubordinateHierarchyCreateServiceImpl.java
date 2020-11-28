package com.company.service;

import com.company.model.PreSubordinate;
import com.company.model.Subordinate;

import java.util.*;
import java.util.stream.Collectors;

public class SubordinateHierarchyCreateServiceImpl implements SubordinateHierarchyCreateService {
    @Override
    public Subordinate createSubordinateHierarchy(Map<String, List<String>> map) {
        List<PreSubordinate> preSubordinateLst = new ArrayList<>();
        for (String key : map.keySet()) {
            PreSubordinate supers = getParentSubordinate(key, map.entrySet(), null);
            preSubordinateLst.add(supers);
            System.out.println(supers);
        }
        return null;
    }

    private PreSubordinate getParentSubordinate(String key, Set<Map.Entry<String, List<String>>> entrySet, PreSubordinate subordinates) {
        PreSubordinate subordinate = new PreSubordinate();
        subordinate.setName(key);
        subordinate.setSubordinates(subordinates);
        String keyes = key;
        String herAcly = entrySet.stream()
                .filter(stringListEntry -> stringListEntry.getValue().contains(key))
                .map(stringListEntry -> stringListEntry.getKey())
                .findFirst().orElse(key);
        if (herAcly.equals(key)) {
            return subordinate;
        } else {
            return getParentSubordinate(herAcly, entrySet, subordinate);
        }
    }

    private Subordinate merges(List<Subordinate> subordinate) {
        Subordinate subordinate1 = new Subordinate();
        subordinate1.setName("кароль");
        List<Subordinate> subordinates = subordinate.stream().filter(subordinate2 -> subordinate2.getSubordinates() == null).collect(Collectors.toList());
        subordinate1.setSubordinates(subordinates);
    }
}
