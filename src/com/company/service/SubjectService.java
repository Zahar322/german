package com.company.service;

import com.company.model.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectService {

    Subject createChain(Map<String, List<String>> map);
}
