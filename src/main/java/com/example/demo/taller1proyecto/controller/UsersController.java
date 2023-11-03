package com.example.demo.taller1proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.taller1proyecto.modelo3.Users;
import com.example.demo.taller1proyecto.service.UsersService;

@RestController
@RequestMapping("users")
public class UsersController {
    private final UsersService userService;

    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers() {
        try {
            Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "name").ignoreCase());
            List<Users> usuarios = userService.findAll(sortBy);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        try {
            Optional<Users> userOptional = userService.findById(id);

            if (userOptional.isPresent()) {
                Users user = (Users) userOptional.get();
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
