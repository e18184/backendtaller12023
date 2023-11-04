package com.example.demo.taller1proyecto.service;

import org.springframework.stereotype.Service;
import com.example.demo.taller1proyecto.modelo3.Usuarios;
import java.util.List;
import org.springframework.data.domain.Sort;

@Service
public interface UsuariosService {
    // void save(Usuarios usuarios);

    // List<Usuarios> getUsuariosList();

    // boolean usuariosFindById(Integer id);

    List<Usuarios> getUsuariosUsuarioContrasenaSql(String usuario, String contrasena);

    // public List<Usuarios> getUsuariosLoginPasswordJpql(String login, String
    // password);

    public List<Usuarios> findByUsuarioAndContrasena(String usuario, String contrasena);

    // public List<Usuarios> findByLoginLike(String login);

    public List<Usuarios> findByCodU(Integer id);

    public List<Usuarios> findAll(Sort sort);

    // // public Usuarios loadUserByUsername(String login, String password) throws
    // // UsernameNotFoundException;

}