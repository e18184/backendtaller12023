package com.example.demo.taller1proyecto.service;

import java.util.List;
import com.example.demo.taller1proyecto.modelo.Menus;

public interface MenusService {
    void save(Menus menus);

    List<Menus> getMenusList();

    List<Menus> findByLoginAndPassword(String login, String password, Long idrol);

}
