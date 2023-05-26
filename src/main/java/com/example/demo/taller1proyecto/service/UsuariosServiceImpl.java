package com.example.demo.taller1proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.taller1proyecto.modelo.Usuarios;
import com.example.demo.taller1proyecto.repository.UsuariosRepository;;;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepo;

    @Override
    public void save(Usuarios usuarios) {
        usuariosRepo.save(usuarios);
    }

    @Override
    public List<Usuarios> getUsuariosList() {
        return usuariosRepo.findAll();
    }

}
