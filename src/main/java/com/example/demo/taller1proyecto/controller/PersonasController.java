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

            if (personaOptional.isPresent()) {
                Personas persona = (Persona) userOptional.get();
                System.out.println("usuario:" + user.toString());
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        try {
            // Long maxId = userService.findMaxId().longValue();
            // System.out.println("id max es: " + maxId);
            // Long newId = (maxId != null) ? maxId + 1 : 1;
            // System.out.println("newId es: " + newId);
            // user.setId(newId);
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @Validated @RequestBody Users user) {
        Optional<Users> usuarioOpcional = userService.findById(id);
        if (!usuarioOpcional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        user.setId(usuarioOpcional.get().getId());
        this.userService.save(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users")
    public List<Users> getUsersByQuery(@RequestParam String model, @RequestParam String query) {
        return userService.getUsersByColumn(model, query);
    }

}
