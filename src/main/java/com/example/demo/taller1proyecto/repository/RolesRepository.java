package com.example.demo.taller1proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.taller1proyecto.modelo3.Roles;

import java.util.List;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    /*
     * @Query("select DISTINCT r from Roles r JOIN Usuarios u ON r.id=u.id AND u.login=?1 and u.password=?2"
     * )
     */
    // public List<Roles> findByLoginAndPassword(String login, String password);

    /*
     * @Query("SELECT DISTINCT r FROM Roles r JOIN r.usuario_roles u " +
     * "WHERE u.login = ?1 AND u.password = ?2") List<Roles>
     * findByLoginAndPassword(String login, String password);
     */
    // de donde sale r.usuarios
    // esto del campo que relaciona ManyToMany a usuarios
    // List<Usuarios> usuarios;

    // public List<Roles> findByUsuarioAndContrasena(String usuario, String
    // contrasena);

}
