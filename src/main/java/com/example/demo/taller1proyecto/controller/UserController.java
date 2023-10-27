package com.example.demo.taller1proyecto.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.taller1proyecto.modelo3.User;
import com.example.demo.taller1proyecto.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        try {
            Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "name").ignoreCase());
            List<User> usuarios = userService.findAll(sortBy);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        try {
            Optional<User> userOptional = userService.findById(id);

            if (userOptional.isPresent()) {
                User user = (User) userOptional.get();
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
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {

        User userGuardada = userService.findTopByOrderByValorEnteroDesc();
        if (userGuardada != null) {

            Integer valormaximo = userGuardada.getId().intValue();
            userGuardada.setId(Long.valueOf(valormaximo + 1));
            userService.save(userGuardada);
        }

        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userGuardada.getId()).toUri();
        return ResponseEntity.created(ubicacion).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Validated @RequestBody User user) {
        Optional<User> usuarioOpcional = userService.findById(id);
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
}
