package com.example.demo.taller1proyecto.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.taller1proyecto.modelo3.User;
import com.example.demo.taller1proyecto.service.UserService;
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
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setName(updatedUser.getName());
        user.setGender(updatedUser.getGender());
        user.setStatus(updatedUser.getStatus());
        System.out.println("estado:"+updatedUser.getStatus());
        user.setEmail(updatedUser.getEmail());
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
