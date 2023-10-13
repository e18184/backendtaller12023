package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.repository.PersonasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.taller1proyecto.modelo3.Personas;
import org.springframework.data.domain.Sort;
import java.util.List;

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

}
