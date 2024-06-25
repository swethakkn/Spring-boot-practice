package com.spring.cruddemo.rest;

import com.spring.cruddemo.entity.Employee;
import com.spring.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    //constructor injection of employee service
    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService){
        this.employeeService = theemployeeService;
    }
    //expose "/employees" endpoint to return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //expose "/employees/{employeeId} endpoint to get single employee by passing Id as path variable
    @GetMapping(path = "/employees/{employeeId}",params = "application/v1+json")
    public Employee getEmployee(@PathVariable("employeeId") int employeeID){
        Employee employee =employeeService.findById(employeeID);
        if (employee==null)
            throw new RuntimeException("Employee not found with Id -"+ employeeID);
        System.out.println("Got employee from version 1");
        return employee;
    }
    @GetMapping(path = "/employees/{employeeId}",produces = "application/v2+json")
    public Employee getEmployeev2(@PathVariable("employeeId") int employeeID){
        Employee employee =employeeService.findById(employeeID);
        if (employee==null)
            throw new RuntimeException("Employee not found with Id -"+ employeeID);
        System.out.println("Got employee from version 2");
        return employee;
    }
    //expose post endpoint to save an employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //just incase if they pass an Id in JSON set it to 0 to force save a new item instead of update
        theEmployee.setEmployeeId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    //expose PUT "/employees" endpoint to update an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    //expose DELETE "/employees/{employeeId}" endpoint to delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        //get an employee by employee id to delete
        Employee employee = employeeService.findById(employeeId);
        if(employee==null)
            throw new RuntimeException("Employee not found to delete with Id"+ employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted Employee Id -"+ employeeId;
    }
}
