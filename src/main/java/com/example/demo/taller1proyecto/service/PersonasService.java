package com.example.demo.taller1proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.example.demo.taller1proyecto.modelo3.Personas;
import com.example.demo.taller1proyecto.modelo3.Users;

public interface PersonasService {
    void save(Personas persona);

    public List<Personas> findAll(Sort sort);

    public void deleteById(Long id);

    public Optional<Personas> findById(Long id);

    public List<Personas> getPersonasByColumn(String column, String query);

    // List<Personas> getPersonaList(); }
}