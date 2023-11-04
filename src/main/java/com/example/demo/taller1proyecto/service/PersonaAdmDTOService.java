package com.example.demo.taller1proyecto.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.query.Param;

import com.example.demo.taller1proyecto.dto.PersonaAdmDTO;

public interface PersonaAdmDTOService {

    public List<PersonaAdmDTO> findBySearchString(@Param("searchString") String searchString, String tipo,
            String estado, Pageable p);
}
