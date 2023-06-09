package com.example.demo.taller1proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.taller1proyecto.modelo.Usuarios;
import com.example.demo.taller1proyecto.repository.UsuariosRepository;

import java.util.List;

@SpringBootApplication
public class HqlExample {
    private final UsuariosRepository usuarioRepository;

    public HqlExample(UsuariosRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HqlExample.class, args);
    }

    @Bean
    public void runQuery() {
        List<Usuarios> usuarios = usuarioRepository.findByLogin("uno");
        for (Usuarios usuario : usuarios) {
            System.out.println(usuario.getLogin() + " " + usuario.getPassword());
        }
    }
}
