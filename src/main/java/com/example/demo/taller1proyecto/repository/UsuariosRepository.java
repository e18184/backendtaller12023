package com.example.demo.taller1proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.taller1proyecto.modelo.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
