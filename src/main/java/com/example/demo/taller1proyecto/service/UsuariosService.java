package com.example.demo.taller1proyecto.service;

import org.springframework.stereotype.Service;
import com.example.demo.taller1proyecto.modelo.Usuarios;
import java.util.List;

@Service
public interface UsuariosService {
    void save(Usuarios usuarios);

    List<Usuarios> getUsuariosList();

    boolean usuariosFindById(Long id);

    List<Usuarios> getUsuariosLoginPasswordSql(String login, String password);

    public List<Usuarios> getUsuariosLoginPasswordJpql(String login, String password);

    public List<Usuarios> findByLoginAndPassword(String login, String password);

    public List<Usuarios> findByLoginLike(String login);
}
