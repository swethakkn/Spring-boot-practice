package com.java.springboot.thymeleafdemo.controllers;

import com.java.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        //create a student object
        Student theStudent = new Student();
        //add student object to the model
        model.addAttribute("student",theStudent);
        //add list of countries to the model
        model.addAttribute("countries",countries);
        //add list of languages to the model
        model.addAttribute("languages",languages);
        //add list of operating systems to the model
        model.addAttribute("systems",systems);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){
      // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " "
                + theStudent.getLastName() + " from "
                + theStudent.getCountry());
      return "student-confirmation";
    }
}
