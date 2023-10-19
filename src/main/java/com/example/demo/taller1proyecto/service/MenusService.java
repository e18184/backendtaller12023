package com.example.demo.taller1proyecto.service;

import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Usuarios;

public interface MenusService {
    List<Menus> getMenusForUsuario(Usuarios usuario);
}
