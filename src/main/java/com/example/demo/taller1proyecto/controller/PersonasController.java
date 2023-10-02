package com.example.demo.taller1proyecto.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.taller1proyecto.service.PersonasService;
import com.example.demo.taller1proyecto.modelo3.Personas;
import com.example.demo.taller1proyecto.modelo3.Usuarios;

@RestController
@RequestMapping("/personascontroller")
public class PersonasController {

    PersonasService personasservice;

    @GetMapping("/")
    public ResponseEntity<List<Personas>> findAll() {
        try {
            Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "nombres").ignoreCase());
            List<Personas> personas = personasservice.findAll(sortBy);
            for (Personas per : personas) {
                per.setSolicitudes_servicio(null);
                per.setTecnicos_ejecutantes(null);
                per.setUsuarios(null);

            }
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (

        Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> find(@PathVariable Integer id) {
    // try {
    // // TODO Implement Your Logic To Get Data From Service Layer Or Directly From
    // // Repository Layer
    // return new ResponseEntity<>("GetOne Result", HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    @PostMapping()
    public ResponseEntity<Personas> create(@RequestBody Personas personas) {
        try {
            Personas per = new Personas();
            per.setApellido_materno(personas.getApellido_materno());
            per.setApellido_paterno(personas.getApellido_paterno());
            per.setCedula_identidad(personas.getCedula_identidad());
            personasservice.save(per);
            return new ResponseEntity<>(per, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PutMapping()
    // public ResponseEntity<?> update(@RequestBody Dto dto) {
    // try {
    // // TODO Implement Your Logic To Update Data And Return Result Through
    // // ResponseEntity
    // return new ResponseEntity<>("Update Result", HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<?> delete(@PathVariable Integer id) {
    // try {
    // // TODO Implement Your Logic To Destroy Data And Return Result Through
    // // ResponseEntity
    // return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }
}
