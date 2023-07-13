package com.example.demo.taller1proyecto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.taller1proyecto.service.UsuariosService;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.taller1proyecto.modelo.Usuarios;

@RestController
@RequestMapping("/usuariocontroller")
public class UsuarioController {
    @Autowired
    UsuariosService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuarios>> findAll() {
        try {
            // esto es una pruebass sdfs
            List<Usuarios> usuario = new ArrayList<Usuarios>();
            usuarioService.findAll().forEach(usuario::add);
            return new ResponseEntity<>(usuario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
