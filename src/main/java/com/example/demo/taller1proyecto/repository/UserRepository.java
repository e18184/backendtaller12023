package com.example.demo.taller1proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.taller1proyecto.modelo3.User;

public interface UserRepository extends JpaRepository<User, Long> {

}