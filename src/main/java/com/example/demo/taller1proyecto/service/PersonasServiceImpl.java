package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.repository.PersonasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.taller1proyecto.modelo3.Personas;

import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonasServiceImpl implements PersonasService {
    @Autowired
    PersonasRepository personRepo;

    @Override
    public void save(Personas persona) {
        personRepo.save(persona);
    }

    @Override
    public List<Personas> findAll(Sort sort) {
        return personRepo.findAll(sort);
    }

    // @Override
    // public List<Personas> getPersonaList() {
    // return personRepo.findAll();
    // }

    @Override
    public void deleteById(Long id) {
        personRepo.deleteById(id);
    }

    @Override
    public Optional<Personas> findById(Long id) {
        return personRepo.findById(id);
    }

    @Override
    public List<Personas> getPersonasByColumn(String column, String query) {
        query = "%" + query + "%";
        switch (column) {
            case "nombres":
                System.out.println(personRepo.findByNombresLike(query));
                return personRepo.findByNombresLike(query);
            default:
                return Collections.emptyList(); // Devuelve una lista vacía si no se proporciona una columna válida
        }
    }

}
