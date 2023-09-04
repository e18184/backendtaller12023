package com.example.demo.taller1proyecto;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.util.Vector;
import java.util.List;
import lombok.*;
import com.example.demo.taller1proyecto.clase.Persona;

@Component
@SessionScope
@Data

public class SessionData {
    private int variable1 = 5;
    private String variable2 = "micadena";
    private Vector<Integer> variable3 = new Vector<>(List.of(1, 2, 3, 4));
    private Persona persona = new Persona("carlos", "sadfa", "asdfa", 34);
}
