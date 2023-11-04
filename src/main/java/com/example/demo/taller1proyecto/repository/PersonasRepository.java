package com.example.demo.taller1proyecto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.taller1proyecto.modelo3.Personas;
import com.example.demo.taller1proyecto.modelo3.Users;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Integer> {
    public List<Personas> findAll(Sort sort);

    Optional<Personas> findById(Integer id);

    List<Personas> findBySeqpersonaLike(String query);

    List<Personas> findByNombresLike(String query);

    List<Personas> findByApellidomaternoLike(String query);

    List<Personas> findByApellidopaternoLike(String query);

    List<Personas> findByCedulaidentidadLike(String query);

    List<Personas> findByCodestadoLike(String query);

    List<Personas> findByCodtipoLike(String query);

    List<Personas> findByFotografiaLike(String query);

    List<Personas> findByTelefonocelularLike(String query);

}
