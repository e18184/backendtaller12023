package com.example.demo.taller1proyecto.service;

import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Procesos;

public interface MenusService {

    public List<Menus> getAllMenus();

    public List<Procesos> getProcesosByMenuId(Long menuId);

    // void save(Menus menus);

    // List<Menus> getMenusList();

    // List<Menus> findByLoginAndPassword(String login, String password, Long
    // idrol);

    // Optional<Menus> findById(Long id);

    // public void deleteById(Long id);

}
