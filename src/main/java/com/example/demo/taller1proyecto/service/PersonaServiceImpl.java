package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.taller1proyecto.modelo3.Personas;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personRepo;

    @Override
    public void save(Personas persona) {
        personRepo.save(persona);
    }

    // @Override
    // public List<Personas> getPersonaList() {
    // return personRepo.findAll();
    // }

}
