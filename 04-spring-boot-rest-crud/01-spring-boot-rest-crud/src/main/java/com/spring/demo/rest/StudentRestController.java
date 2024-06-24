package com.spring.demo.rest;

import com.spring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    //Define @PostConstruct to load students data... only once
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Swetha","Kakani"));
        students.add(new Student("Venkat","Arikatla"));
        students.add(new Student("Rithwik","Arikatla"));
        students.add(new Student("Vihaan","Arikatla"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    //Define an endpoint "/students/{studentId}" retrieve a single student by ID--PathVariable
    @GetMapping("/students/{studentId}")
    public Student getSingleStudent(@PathVariable int studentId){
        //check the studentId against the list size
        if((studentId>=students.size()) || (studentId<0)) {
            throw new StudentNotFoundException("Student Id not found-" + studentId);
        }
        return students.get(studentId);
    }

}
