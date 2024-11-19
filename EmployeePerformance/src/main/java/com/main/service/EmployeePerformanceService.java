package com.main.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Employee;
import com.main.model.RatingCategory;
import com.main.repository.EmployeeRepository;
import com.main.repository.RatingCategoryRepository;

@Service
public class EmployeePerformanceService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RatingCategoryRepository ratingCategoryRepository;

    public Map<String, Long> calculateActualPercentages() {
        List<Employee> employees = employeeRepository.findAll();
        long totalEmployees = employees.size();

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getRating, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> (e.getValue() * 100) / totalEmployees
                ));
    }

  
    public Map<String, Double> calculateDeviation() {
        Map<String, Long> actualPercentages = calculateActualPercentages();
        List<RatingCategory> categories = ratingCategoryRepository.findAll();

        return categories.stream()
                .collect(Collectors.toMap(
                        RatingCategory::getCategory,
                        category -> {
                            long actual = actualPercentages.getOrDefault(category.getCategory(), 0L);
                            return (double) actual - category.getStandardPercentage();
                        }
                ));
    }


    public List<Employee> suggestRevisions(String category) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getRating().equals(category))
                .collect(Collectors.toList());
    }
}
