package com.example.demo.taller1proyecto.service;

import org.springframework.stereotype.Service;
import com.example.demo.taller1proyecto.modelo.Usuarios;
import java.util.List;
import org.springframework.data.domain.Sort;

@Service
public interface UsuariosService {
    void save(Usuarios usuarios);

    List<Usuarios> getUsuariosList();

    boolean usuariosFindById(Long id);

    List<Usuarios> getUsuariosLoginPasswordSql(String login, String password);

    public List<Usuarios> getUsuariosLoginPasswordJpql(String login, String password);

    public List<Usuarios> findByLoginAndPassword(String login, String password);

    public List<Usuarios> findByLoginLike(String login);

    public List<Usuarios> findById(Integer id);

    public List<Usuarios> findAll(Sort sort);

    // public Usuarios loadUserByUsername(String login, String password) throws
    // UsernameNotFoundException;

}
