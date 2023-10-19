package com.example.demo.taller1proyecto.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.taller1proyecto.modelo3.Procesos;

public interface ProcesosRepository extends JpaRepository<Procesos, Long> {

=======
import com.example.demo.taller1proyecto.modelo3.Procesos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// hay dos modelos 
// JpaRepository 
// CrudRepository
// JpàRepository recibe 2 argumentos 
// 1ero es la clase sobre la cual actua
// es la llave primaria de la clase. Normalmente es Intero
// en el JpaRepository es Long

public interface ProcesosRepository extends JpaRepository<Procesos, Long> {
    /*
     * @Query("SELECT DISTINCT p FROM Procesos p JOIN p.menus m JOIN m.roles r JOIN r.usuarios u WHERE u.login = ?1 AND u.password = ?2 AND r.codr = ?3"
     * ) List<Procesos> findByLoginAndPassword(String login, String password, Long
     * idrol, Long idmenu);
     */
>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95
}