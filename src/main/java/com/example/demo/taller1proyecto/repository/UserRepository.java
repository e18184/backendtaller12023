package com.example.demo.taller1proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.taller1proyecto.modelo3.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    User findTopByOrderByValorEnteroDesc();

}
