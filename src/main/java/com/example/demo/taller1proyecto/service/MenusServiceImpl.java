package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Roles;
import com.example.demo.taller1proyecto.modelo3.Usuarios;
import com.example.demo.taller1proyecto.repository.MenusRepository;
import com.example.demo.taller1proyecto.repository.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private MenusRepository menusRepository;

    @Override
    public List<Menus> getMenusForUsuario(Usuarios usuario) {
        List<Roles> roles = new ArrayList<>(usuario.getId_rol());
        List<Menus> menus = new ArrayList<>();

        for (Roles rol : roles) {
            menus.addAll(rol.getCodm());
        }

        return menus;
    }

}
