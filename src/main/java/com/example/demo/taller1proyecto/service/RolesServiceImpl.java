package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.repository.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.taller1proyecto.modelo3.Roles;
import com.example.demo.taller1proyecto.modelo3.Usuarios;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesRepository rolesRepo;

    @Override
    public void save(Roles roles) {
        rolesRepo.save(roles);
    }

    @Override
    public List<Roles> getRolesList() {
        return rolesRepo.findAll();
    }

    // public List<Roles> findByLoginAndPassword(String login, String password) {
    // return rolesRepo.findByLoginAndPassword(login, password);
    // }

    public Optional<Roles> findById(Long id) {
        return rolesRepo.findById(id);
    }

    public void deleteById(Long id) {
        rolesRepo.deleteById(id);
    }

    @Override
    public List<Roles> findByUsuarios(Usuarios usuarios) {
        return rolesRepo.findByUsuarioAndContrasena(usuarios.getUsuario(), usuarios.getContrasena());
    }

}
