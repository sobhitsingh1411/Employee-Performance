package com.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Employee;
import com.main.service.EmployeePerformanceService;

@RestController
public class EmployeePerformanceController {

    @Autowired
    private EmployeePerformanceService service;

    @GetMapping("/actual-percentages")
    public Map<String, Long> getActualPercentages() {
        return service.calculateActualPercentages();
    }

    @GetMapping("/deviation")
    public Map<String, Double> getDeviation() {
        return service.calculateDeviation();
    }

    @GetMapping("/suggest-revisions/{category}")
    public List<Employee> suggestRevisions(@PathVariable String category) {
        return service.suggestRevisions(category);
    }
}
