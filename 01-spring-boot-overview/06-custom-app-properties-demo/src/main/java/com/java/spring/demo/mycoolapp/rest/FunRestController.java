package com.java.spring.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //Inject the custom properties using @Value annotation
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // Expose "/teaminfo" to get the custom properties
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach : " + coachName + ", TeamName: " + teamName;
    }
    // Expose "/" that return hello world
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "Bye Bye!";
    }



}
