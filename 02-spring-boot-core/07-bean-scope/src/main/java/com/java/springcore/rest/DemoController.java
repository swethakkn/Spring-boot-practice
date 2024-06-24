package com.java.springcore.rest;

import com.java.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;
    @Autowired
    public DemoController(@Qualifier ("cricketCoach") Coach coach,@Qualifier ("cricketCoach") Coach thecoach){
        this.myCoach = coach;
        this.anotherCoach = thecoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    // to check the scope of bean either it is singleton or prototype
    @GetMapping("/check")
    public String getScope(){
        return "Comparing beans:myCoach==anotherCoach,"+ (myCoach==anotherCoach);
    }
}
