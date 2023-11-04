/*
 * package com.example.demo.taller1proyecto.repository;
 * 
 * import com.example.demo.taller1proyecto.dto.PersonaAdmDTO;
 * 
 * import java.util.List;
 * 
 * import
 * org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.
 * Pageable; import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.data.jpa.repository.Query; import
 * org.springframework.data.repository.query.Param;
 * 
 * 
 * public interface PersonaAdmDTORepository extends JpaRepository<PersonaAdmDTO,
 * Integer> {
 * 
 * @Query("select e from PersonaAdmDTO p where concat(trim(nombre), trim(ap), trim(am)) like %:searchString% AND tipo=?1 AND estado=?2?"
 * ) List<PersonaAdmDTO> findBySearchString(@Param("searchString") String
 * searchString, String tipo, String estado, Pageable p); }
 */