package com.example.demo.taller1proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.taller1proyecto.modelo.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    @Query("select DISTINCT r from Roles r JOIN Usuarios u ON r.id=u.id AND u.login=?1 and u.password=?2")

    public List<Roles> findByLoginAndPassword(String login, String password);

}
