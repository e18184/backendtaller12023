package com.example.demo.taller1proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.taller1proyecto.modelo3.Users;

import java.util.Optional;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findById(Integer id);

    List<Users> findByNameLike(String query);

    List<Users> findByEmailLike(@Param("query") String query);

    List<Users> findByGenderLike(@Param("query") String query);

    List<Users> findByStatusLike(@Param("query") String query);
}
