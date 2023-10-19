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
