package com.java.springboot.resttemplate.controller;

import com.java.springboot.resttemplate.entity.College;
import com.java.springboot.resttemplate.entity.Student;
import com.java.springboot.resttemplate.entity.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private WebClient.Builder webClient;
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable("studentId") long studentId){
        StudentResponse studentResponse = new StudentResponse();
        Student student = new Student(1,"Swetha",1);
        studentResponse.setStudent(student);
        long collegeId = student.getCollegeId();
        String endpoint = "http://localhost:9090/college/{collegeId}";
        /*
        //RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<College> collegeDetails = restTemplate
                                                    .getForEntity(endpoint,College.class,collegeId);
        if(collegeDetails.getStatusCode().value() == 200)
        {
            College college = collegeDetails.getBody();
            studentResponse.setCollege(college);
        }
        */
        //WebClient
        College college = webClient.build().get().uri("http://localhost:9090/college/"+ collegeId)
                                    .retrieve().bodyToMono(College.class).block();
        studentResponse.setCollege(college);

        return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
    }
}
