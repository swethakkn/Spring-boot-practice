package com.java.springcore.rest;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.java.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    @Autowired
    public DemoController(@Qualifier ("trackCoach") Coach coach){
        System.out.println("In Constructor:" + getClass().getSimpleName());
        this.myCoach = coach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
