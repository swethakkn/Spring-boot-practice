package com.spring.cruddemo.service;

import com.spring.cruddemo.dao.EmployeeRepository;
import com.spring.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    //set up constructor injection employeeDAO
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }



    @Override
    public Employee findById(int theId) {
        //get the employee from DAO method
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if(result.isPresent())
            employee=result.get();
        else
            throw new RuntimeException("not found an Employee with id-"+theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }

}
