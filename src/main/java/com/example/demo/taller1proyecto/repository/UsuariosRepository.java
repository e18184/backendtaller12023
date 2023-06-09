package com.example.demo.taller1proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.taller1proyecto.modelo.Usuarios;
import java.util.List;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    // listar nombre, ap, am, usuario, contrasena
    // JPQL trabaja en las clases y no en las tablas
    // 1.- Si la consulta es SQL se estaria trabajando con las tablas
    // @Query(value = "select max(u.id) from usuarios u ", nativeQuery = true)
    // si queremos usar las Clases
    // @Query("select max(u.id) from usuarios u ")
    // hay con parametros....
    // consulta SQL
    // lo que hacemos en el pgadmin
    @Query(value = "select codu, login, password, estado,persona_codu from t_usuarios u where u.login=?1 and u.password=?2", nativeQuery = true)
    public List<Usuarios> getUsuariosLoginPasswordSql(String login, String password);

    // consulta JPQL
    // clases.

    @Query("select u from Usuarios u where u.login=?1 and u.password=?2")
    public List<Usuarios> getUsuariosLoginPasswordJpql(String login, String password);

    public List<Usuarios> findByLogin(String login);

}
