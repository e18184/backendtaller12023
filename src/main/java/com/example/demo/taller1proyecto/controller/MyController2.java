package com.example.demo.taller1proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.taller1proyecto.SessionData;
import com.example.demo.taller1proyecto.clase.Persona;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/sesiones2")
@SessionAttributes({ "variable1", "variable2", "variable3", "variable4" })

public class MyController2 {

    @Autowired
    private SessionData sessionData;

    @GetMapping("/getSession2")
    public String getSession2(Model model) {
        model.addAttribute("variable1", sessionData.getVariable1());
        model.addAttribute("variable2", sessionData.getVariable2());
        model.addAttribute("variable3", sessionData.getVariable3());
        model.addAttribute("persona", sessionData.getPersona());

        System.out.println("variable1:" + model.getAttribute("variable1"));
        System.out.println("variable2:" + model.getAttribute("variable2"));
        System.out.println("variable3:" + model.getAttribute("variable3"));
        Persona per = (Persona) model.getAttribute("persona");
        System.out.println("persona:" + per.getNombre() + " " + per.getAp() + " " + per.getAm() + " " + per.getEdad());

        return "mostrar"; // Reemplaza con el nombre de tu vista
    }

}
