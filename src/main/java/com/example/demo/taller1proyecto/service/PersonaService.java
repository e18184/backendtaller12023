package com.example.demo.taller1proyecto.service;

import java.util.List;
import com.example.demo.taller1proyecto.modelo.Persona;

public interface PersonaService {
    void save(Persona persona);

    List<Persona> getPersonaList();

}
