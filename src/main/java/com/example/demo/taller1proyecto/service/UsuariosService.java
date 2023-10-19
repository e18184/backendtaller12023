package com.example.demo.taller1proyecto.service;

import org.springframework.stereotype.Service;

import com.example.demo.taller1proyecto.modelo3.Usuarios;

@Service
public interface UsuariosService {
    Usuarios authenticateUsuario(String usuario, String contrasena);
}
