package com.java.springboot.studentfeignclient.controller;

import com.java.springboot.studentfeignclient.entity.College;
import com.java.springboot.studentfeignclient.entity.Student;
import com.java.springboot.studentfeignclient.entity.StudentResponse;
import com.java.springboot.studentfeignclient.utils.FeignClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private FeignClientUtil feignClientUtil;
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable("studentId") long studentId){
        Student student = new Student(1,"Swetha",1);
        long collegeId = student.getCollegeId();
        StudentResponse response = new StudentResponse();
        response.setStudent(student);
        College college = feignClientUtil.getCollege(collegeId).getBody();
        response.setCollege(college);
        return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
    }
}
