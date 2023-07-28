package com.example.demo.taller1proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.taller1proyecto.modelo.Procesos;
import com.example.demo.taller1proyecto.service.ProcesosService;

@RestController
@RequestMapping("/procesoscontroller")
public class ProcesosController {

    @Autowired
    ProcesosService procesosService;

    @GetMapping("/{login}/{password}/{idrol}/{idmenu}")
    public ResponseEntity<List<Procesos>> findProcesos(@PathVariable String login, @PathVariable String password,
            @PathVariable Long idrol, @PathVariable Long idmenu) {
        try {

            List<Procesos> usuarios = procesosService.findByLoginAndPassword(login, password, idrol, idmenu);
            List<Procesos> usuariosprocesos = new ArrayList<>();

            // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Procesos procesos : usuarios) {
                Procesos usuarioprocesos = new Procesos();

                usuarioprocesos.setNombre(procesos.getNombre());
                usuarioprocesos.setEnlace(procesos.getEnlace());
                usuariosprocesos.add(usuarioprocesos);
            }
            return new ResponseEntity<>(usuariosprocesos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
