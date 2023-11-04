package com.example.demo.taller1proyecto.service;

import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Procesos;

public interface MenusService {

    public List<Menus> getAllMenus();

    public List<Procesos> getProcesosByMenuId(Integer menuId);

    // void save(Menus menus);

    // List<Menus> getMenusList();

    // List<Menus> findByLoginAndPassword(String login, String password, Integer
    // idrol);

    // Optional<Menus> findById(Integer id);

    // public void deleteById(Integer id);

}
