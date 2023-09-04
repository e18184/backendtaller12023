package com.example.demo.taller1proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/sesiones")
public class MyController {
    @GetMapping("/setSession")
    public String setSession(HttpSession session) {
        session.setAttribute("username", "user1");
        // Otros atributos de sesión
        return "redirect:/home";
    }

    @GetMapping("/getSession")
    @ResponseBody
    public String getSession(HttpSession session) {
        String username = (String) session.getAttribute("username");
        // Obtén otros atributos de sesión
        return "Username: " + username;
    }

    @GetMapping("/clearSession")
    public String clearSession(HttpSession session) {
        session.invalidate(); // Limpia todos los atributos de sesión
        return "redirect:/login";
    }
}
