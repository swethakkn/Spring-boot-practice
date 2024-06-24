package com.java.springboot.thymeleafdemo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    //add method for hellloworld-show form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    //add method to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //read form data, process it and add to the model
    @RequestMapping("/processFormV2")
    public String processFormV2(HttpServletRequest request, Model model){
        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        //convert it into uppercase
        theName = theName.toUpperCase();
        //create a message
        String result = "Yo!"+ theName;
        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String theName, Model model){
        //read the request parameter from the HTML form
        //String theName = request.getParameter("studentName");
        //convert it into uppercase
        theName = theName.toUpperCase();
        //create a message
        String result = "Hello My friend! "+ theName + " Message from V3";
        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
