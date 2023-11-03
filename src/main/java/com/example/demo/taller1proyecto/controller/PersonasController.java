package com.example.demo.taller1proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.taller1proyecto.service.PersonasService;
import com.example.demo.taller1proyecto.service.UsersService;
import com.example.demo.taller1proyecto.modelo3.Personas;
import com.example.demo.taller1proyecto.modelo3.Users;

@RestController
@RequestMapping("/personascontroller")
public class PersonasController {
    private final PersonasService personasService;

    public PersonasController(PersonasService personasService) {
        this.personasService = personasService;
    }

    @GetMapping
    public ResponseEntity<List<Personas>> getPersonas() {
        try {
            Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "nombres").ignoreCase());
            List<Personas> personas = personasService.findAll(sortBy);
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personas> findById(@PathVariable Long id) {
        try {
            Optional<Personas> personasOptional = personasService.findById(id);

            if (personasOptional.isPresent()) {
                Personas persona = (Personas) personasOptional.get();
                System.out.println("usuario:" + persona.toString());
                return new ResponseEntity<>(persona, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Personas> createUser(@RequestBody Personas personas) {
        try {
            personasService.save(personas);
            return new ResponseEntity<>(personas, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updatePersonas(@PathVariable Long id, @Validated @RequestBody Personas personas) {
        Optional<Personas> usuarioOpcional = personasService.findById(id);
        if (!usuarioOpcional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        personas.setSeq_persona(usuarioOpcional.get().getSeq_persona());
        this.personasService.save(personas);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deletePersonas(@PathVariable Long id) {
        personasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/personas")
    public List<Personas> getPersonasByQuery(@RequestParam String model, @RequestParam String query) {
        return personasService.getPersonasByColumn(model, query);
    }

}
