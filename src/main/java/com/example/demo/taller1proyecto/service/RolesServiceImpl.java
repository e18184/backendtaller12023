package com.example.demo.taller1proyecto.service;

<<<<<<< HEAD
import com.example.demo.taller1proyecto.modelo3.Roles;
=======
>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95
import com.example.demo.taller1proyecto.repository.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;

import com.example.demo.taller1proyecto.modelo3.Roles;
import com.example.demo.taller1proyecto.modelo3.Usuarios;
>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95

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

<<<<<<< HEAD
=======
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

>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95
}
