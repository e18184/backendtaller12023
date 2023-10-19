package com.example.demo.taller1proyecto.service;

import java.util.List;
<<<<<<< HEAD

import com.example.demo.taller1proyecto.modelo3.Roles;
=======
import java.util.Optional;

import com.example.demo.taller1proyecto.modelo3.Roles;
import com.example.demo.taller1proyecto.modelo3.Usuarios;
>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95

public interface RolesService {
    void save(Roles roles);

    List<Roles> getRolesList();

<<<<<<< HEAD
=======
    // public List<Roles> findByLoginAndPassword(String login, String password);

    Optional<Roles> findById(Long id);

    public void deleteById(Long id);

    public List<Roles> findByUsuarios(Usuarios usuarios);

>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95
}
