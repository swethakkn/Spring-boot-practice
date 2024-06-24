package com.java.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("Cricket coach constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling daily for 15 minutes";
    }
}
