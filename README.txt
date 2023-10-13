COMO UTILIZAR QUASAR 
https://quasar.dev/


Definimos el backend 
package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@org.hibernate.annotations.Proxy(lazy = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String email;

}

DEFINIR REPOSITORY 
package com.example.demo.taller1proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.taller1proyecto.modelo3.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

DEFINIR SERVICE 
package com.example.demo.taller1proyecto.service;
import java.util.Optional;

import com.example.demo.taller1proyecto.modelo3.User;
import java.util.List;

public interface UserService {
    public List findAll();

    public User save(User user);

    public Optional<User> findById(Long id);

    public void deleteById(Long id);

}

package com.example.demo.taller1proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.taller1proyecto.modelo3.User;
import com.example.demo.taller1proyecto.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}

DEFINIR EL CONTROLADOR 
package com.example.demo.taller1proyecto.controller;

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

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
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
        user.setFirst_name(updatedUser.getFirst_name());
        user.setEmail(updatedUser.getEmail());
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

DEFINIR EL FRONT END
vue 3, axios, postgresql, quasar 
opcion 1.- quasar.- Se puede desarrollar, con su propia estructura de proyecto 
opcion 2.- integrarse a un proyecto ya echo

opcion1 .- 
npm init quasar // ingresamos a un menu de opciones 
elejimo la opcion 1 
 App with Quasar CLI, let's go!
elijo 
 Quasar v2 (Vue 3 | latest and greatest) - recommended

? Pick script type: » - Use arrow-keys. Return to submit.
>   Javascript (elijo la opcion 1)
    Typescript

 Pick Quasar App CLI variant: » - Use arrow-keys. Return to submit.
>   Quasar App CLI with Vite - recommended (elejimos 1)
    Quasar App CLI with Webpack

? Pick your CSS preprocessor: » - Use arrow-keys. Return to submit.
>   Sass with SCSS syntax (elijo opcion 1)
    Sass with indented syntax
    None (the others will still be available)

? Check the features needed for your project: »
Instructions:
    ↑/↓: Highlight option
    ←/→/[space]: Toggle selection
    a: Toggle all
    enter/return: Complete answer
(*)   ESLint
( )   State Management (Pinia)
( )   State Management (Vuex) [DEPRECATED by Vue Team]
(*)   Axios
( )   Vue-i18n

? Pick an ESLint preset: » - Use arrow-keys. Return to submit.
>   Prettier - https://github.com/prettier/prettier
    Standard
    Airbnb

nota.- Elejimos cualquiera

abrimos con el editor code .







