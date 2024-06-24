package com.java.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    public BaseBallCoach(){
        System.out.println("In Constructor:" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice batting for 1 hr";
    }
}
