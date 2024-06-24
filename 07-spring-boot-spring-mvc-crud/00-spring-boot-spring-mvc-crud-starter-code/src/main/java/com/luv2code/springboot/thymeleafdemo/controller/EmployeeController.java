package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }
    //add code to list all employees
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        //get the employees from the db
        List<Employee> theEmployees = employeeService.findAll();
        //add employees list to model
        theModel.addAttribute("employees",theEmployees);
        //return list-employees form
        return "/employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee ){
        //save an employee
        employeeService.save(theEmployee);
        //redirect to avoid duplicate submissions
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){
        //get employee from db
        Employee theEmployee = employeeService.findById(theId);
        //set employee to the model to pre-populate the form
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        //delete an employee
        employeeService.deleteById(theId);
        //return employees list form
        return "redirect:/employees/list";
    }

}
