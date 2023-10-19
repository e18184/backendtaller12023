package com.example.demo.taller1proyecto.service;

import org.springframework.stereotype.Service;
<<<<<<< HEAD

import com.example.demo.taller1proyecto.modelo3.Usuarios;

@Service
public interface UsuariosService {
    Usuarios authenticateUsuario(String usuario, String contrasena);
}
=======
import com.example.demo.taller1proyecto.modelo3.Usuarios;
import java.util.List;
import org.springframework.data.domain.Sort;

@Service
public interface UsuariosService {
    // void save(Usuarios usuarios);

    // List<Usuarios> getUsuariosList();

    // boolean usuariosFindById(Long id);

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
>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95
