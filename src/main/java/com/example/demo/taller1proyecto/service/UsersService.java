package com.example.demo.taller1proyecto.service;

import java.util.Optional;

import com.example.demo.taller1proyecto.modelo3.Users;
import java.util.List;
import org.springframework.data.domain.Sort;

public interface UsersService {
    public List findAll(Sort sort);

    public Users save(Users user);

    public Optional<Users> findById(Integer id);

    public void deleteById(Integer id);

    public List<Users> getUsersByColumn(String column, String query);

}
