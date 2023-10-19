package com.example.demo.taller1proyecto.service;

import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Roles;

public interface RolesService {
    void save(Roles roles);

    List<Roles> getRolesList();

}
