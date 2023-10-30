package com.example.demo.taller1proyecto.service;

import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Menus;

public interface RolesService {

    List<Menus> getMenusByRoles(Long roleId);

    // void save(Roles roles);

    // List<Roles> getRolesList();

    // // public List<Roles> findByLoginAndPassword(String login, String password);

    // Optional<Roles> findById(Long id);

    // public void deleteById(Long id);

    // public List<Roles> findByUsuarios(Usuarios usuarios);

}
