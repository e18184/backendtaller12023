package com.example.demo.taller1proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.taller1proyecto.modelo.Menus;
import com.example.demo.taller1proyecto.service.MenusService;
//import com.example.demo.taller1proyecto.service.RolesService;

@RestController
@RequestMapping("/menuscontroller")
public class MenusController {

    @Autowired
    MenusService menuService;

    @GetMapping("/{login}/{password}")
    public ResponseEntity<List<Menus>> findRoles(@PathVariable String login, @PathVariable String password,
            @PathVariable Long idrol) {
        try {
            List<Menus> usuarios = menuService.findByLoginAndPassword(login, password, idrol);
            List<Menus> usuariosmenus = new ArrayList<>();

            // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Menus menus : usuarios) {
                Menus usuariomenus = new Menus();
                usuariomenus.setNombre(menus.getNombre());
                usuariosmenus.add(usuariomenus);
            }
            return new ResponseEntity<>(usuariosmenus, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
