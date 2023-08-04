
package com.example.demo.taller1proyecto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.taller1proyecto.service.RolesService;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.taller1proyecto.modelo.Roles;

@RestController
@RequestMapping("/rolescontroller")
public class RolesController {

    // realizar un metodo para devolver los roles asociados al usuario
    // findById(Integer id)
    // Clase Rol
    // salida
    // los roles que tiene un usuario
    // ejemplo:
    // nombre rol
    // docente
    // estudiante
    @Autowired
    RolesService rolesService;

    @GetMapping("/{login}/{password}")
    public ResponseEntity<List<Roles>> findRoles(@PathVariable String login, @PathVariable String password) {
        try {
            List<Roles> usuarios = rolesService.findByLoginAndPassword(login, password);
            List<Roles> usuariosroles = new ArrayList<>();

            // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Roles roles : usuarios) {
                Roles usuariorol = new Roles();
                usuariorol.setNombre(roles.getNombre());
                usuariosroles.add(usuariorol);
            }
            return new ResponseEntity<>(usuariosroles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/guardar")
    public ResponseEntity<Roles> create(@RequestBody Roles roles) {
        try {
            Roles rol = new Roles();
            rol.setNombre(roles.getNombre());
            rol.setEstado(roles.getEstado());

            rolesService.save(rol);

            return new ResponseEntity<>(rol, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Roles> actualizar(@PathVariable("id") Long id, @RequestBody Roles roles) {
        try {
            Roles rol = rolesService.findById(id).get();

            if (Objects.nonNull(rol)) {

                rol.setNombre(roles.getNombre());
                rol.setEstado(roles.getEstado());
                rolesService.save(rol);

            }
            return new ResponseEntity<Roles>(rol, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
