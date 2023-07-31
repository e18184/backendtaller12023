package com.example.demo.taller1proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.taller1proyecto.modelo.Roles;

import jakarta.transaction.Transactional;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    /*
     * @Query("select DISTINCT r from Roles r JOIN Usuarios u ON r.id=u.id AND u.login=?1 and u.password=?2"
     * )
     * 
     * public List<Roles> findByLoginAndPassword(String login, String password);
     */

    @Query("SELECT DISTINCT r FROM Roles r JOIN r.usuarios u " + "WHERE u.login = ?1 AND u.password = ?2")
    List<Roles> findByLoginAndPassword(String login, String password);
    // de donde sale r.usuarios
    // esto del campo que relaciona ManyToMany a usuarios
    // List<Usuarios> usuarios;

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = " insert into Roles (nombre,estado) values (?1 , ?2) ", nativeQuery = true)
    public Integer guardarRol(String nombre, Integer estado);

}
