package com.java.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice batting for 1 hr";
    }
}
