package com.example.demo.taller1proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Usuarios;
import com.example.demo.taller1proyecto.repository.UsuariosRepository;;;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public Usuarios authenticateUsuario(String usuario, String contrasena) {
        Usuarios user = usuariosRepository.findByUsuario(usuario);
        if (user != null && user.getContrasena().equals(contrasena)) {
            return user;
        }
        return null;
    }
}