package com.example.demo.taller1proyecto.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.taller1proyecto.modelo3.Personas;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Long> {
    public List<Personas> findAll(Sort sort);
}
