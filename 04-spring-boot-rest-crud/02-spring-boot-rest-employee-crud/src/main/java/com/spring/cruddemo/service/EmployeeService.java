package com.spring.cruddemo.service;

import com.spring.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByID(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

}
