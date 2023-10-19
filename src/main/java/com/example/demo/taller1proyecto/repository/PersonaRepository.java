package com.example.demo.taller1proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.taller1proyecto.modelo3.Personas;

// hay dos modelos 
// JpaRepository 
// CrudRepository
// JpàRepository recibe 2 argumentos 
// 1ero es la clase sobre la cual actua
// es la llave primaria de la clase. Normalmente es Intero
// en el JpaRepository es Long

public interface PersonaRepository extends JpaRepository<Personas, Long> {

}
