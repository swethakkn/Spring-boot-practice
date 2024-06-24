package com.java.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    //add request mapping for login page
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        //return "plain-login";
        return "fancy-login";
    }
    //add request mapping for access denied
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        //return "plain-login";
        return "access-denied";
    }
}
