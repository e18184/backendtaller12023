package com.example.demo.taller1proyecto.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.taller1proyecto.modelo3.Users;
import com.example.demo.taller1proyecto.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository userRepository;

    @Override
    public List findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<Users> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<Users> getUsersByColumn(String column, String query) {
        query = "%" + query + "%";
        switch (column) {
            case "name":
                System.out.println(userRepository.findByNameLike(query));
                return userRepository.findByNameLike(query);
            case "email":
                return userRepository.findByEmailLike(query);
            case "gender":
                return userRepository.findByGenderLike(query);
            case "status":
                return userRepository.findByStatusLike(query);
            default:
                return Collections.emptyList(); // Devuelve una lista vacía si no se proporciona una columna válida
        }
    }

}
