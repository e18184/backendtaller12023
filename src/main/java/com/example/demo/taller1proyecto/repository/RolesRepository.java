package com.example.demo.taller1proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    @Query("SELECT r.codm FROM Roles r WHERE r.idrol = :roleId")
    List<Menus> getMenusByRoles(@Param("roleId") Integer roleId);

    /*
     * @Query("select DISTINCT r from Roles r JOIN Usuarios u ON r.id=u.id AND u.login=?1 and u.password=?2"
     * )
     */
    // public List<Roles> findByLoginAndPassword(String login, String password);

    /*
     * @Query("SELECT DISTINCT r FROM Roles r JOIN r.usuarioroles u " +
     * "WHERE u.login = ?1 AND u.password = ?2") List<Roles>
     * findByLoginAndPassword(String login, String password);
     */
    // de donde sale r.usuarios
    // esto del campo que relaciona ManyToMany a usuarios
    // List<Usuarios> usuarios;

    // public List<Roles> findByUsuarioAndContrasena(String usuario, String
    // contrasena);

}
