package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findByID(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

}
