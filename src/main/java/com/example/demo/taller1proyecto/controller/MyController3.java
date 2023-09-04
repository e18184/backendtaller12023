package com.example.demo.taller1proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequestMapping("/sesiones3")
@SessionAttributes("username")
public class MyController3 {
    @ModelAttribute("username")
    public String setUsername() {
        return "user1";
    }

    @GetMapping("/getSession")
    @ResponseBody
    public String getSession(@ModelAttribute("username") String username) {
        System.out.println("Username: " + username);
        return "Username: " + username;
    }

}
