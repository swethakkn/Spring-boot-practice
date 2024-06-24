package com.java.springboot.studentfeignclient.utils;

import com.java.springboot.studentfeignclient.entity.College;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "feignDemo",url = "http://localhost:9090/college")
public interface FeignClientUtil {
    @GetMapping("/{collegeId}")
    ResponseEntity<College> getCollege(@PathVariable("collegeId") long collegeId);
}
