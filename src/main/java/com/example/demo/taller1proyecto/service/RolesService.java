package com.example.demo.taller1proyecto.service;

import java.util.List;
import com.example.demo.taller1proyecto.modelo.Roles;

public interface RolesService {
    void save(Roles roles);

    List<Roles> getRolesList();

    public List<Roles> findByLoginAndPassword(String login, String password);
}
