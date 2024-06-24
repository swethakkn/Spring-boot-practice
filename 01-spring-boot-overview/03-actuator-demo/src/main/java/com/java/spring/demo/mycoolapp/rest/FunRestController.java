package com.java.spring.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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
