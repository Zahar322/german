package com.company.service;

import com.company.model.Subordinate;

import java.util.List;
import java.util.Map;

public interface SubordinateHierarchyCreateService {
    Subordinate createSubordinateHierarchy(Map<String, List<String>> map);
}
