package com.java.utils;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("Cricket coach constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling daily for 15 minutes";
    }
}
