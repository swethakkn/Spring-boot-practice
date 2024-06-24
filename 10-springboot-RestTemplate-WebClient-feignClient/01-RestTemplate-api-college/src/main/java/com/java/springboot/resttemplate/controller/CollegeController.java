package com.java.springboot.resttemplate.controller;

import com.java.springboot.resttemplate.entity.College;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @GetMapping("/{collegeId}")
    public ResponseEntity<College> getCollege(@PathVariable("collegeId") long collegeId){
        College college = new College();
        college.setCollegeId(1);
        college.setCollegeName("PEC");
        college.setCollegeAddress("KDK");
        return new ResponseEntity<College>(college, HttpStatus.OK);
    }
}
