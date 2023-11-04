package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.taller1proyecto.modelo.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personRepo;

    @Override
    public void save(Persona persona) {
        personRepo.save(persona);
    }

    @Override
    public List<Persona> getPersonaList() {
        return personRepo.findAll();
    }

}
