package com.example.demo.taller1proyecto.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.demo.taller1proyecto.modelo3.Personas;

public interface PersonasService {
    void save(Personas persona);

    public List<Personas> findAll(Sort sort);

    public void deleteById(Long id);

    // List<Personas> getPersonaList(); }
}