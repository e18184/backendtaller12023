package com.example.demo.taller1proyecto.repository;

import com.example.demo.taller1proyecto.modelo.Persona;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

// hay dos modelos 
// JpaRepository 
// CrudRepository
// JpàRepository recibe 2 argumentos 
// 1ero es la clase sobre la cual actua
// es la llave primaria de la clase. Normalmente es Intero
// en el JpaRepository es Long

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
