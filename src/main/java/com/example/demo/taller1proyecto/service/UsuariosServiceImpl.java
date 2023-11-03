package com.example.demo.taller1proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Usuarios;
import com.example.demo.taller1proyecto.repository.UsuariosRepository;
import org.springframework.data.domain.Sort;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepo;

    // @Override
    // public void save(Usuarios usuarios) {
    // usuariosRepo.save(usuarios);
    // }

    // @Override
    // public List<Usuarios> getUsuariosList() {

    // return usuariosRepo.findAll();
    // }

    // public boolean usuariosFindById(Long id) {

    // return usuariosRepo.findById(id).isPresent();
    // }

    public List<Usuarios> getUsuariosUsuarioContrasenaSql(String usuario, String contrasena) {
        return usuariosRepo.getUsuariosUsuarioContrasenaSql(usuario, contrasena);
    }

    // public List<Usuarios> getUsuariosLoginPasswordJpql(String login, String
    // password) {
    // return usuariosRepo.getUsuariosLoginPasswordJpql(login, password);
    // }
    public List<Usuarios> findByUsuarioAndContrasena(String usuario, String contrasena) {
        return usuariosRepo.findByUsuarioAndContrasena(usuario, contrasena);
    }

    // public List<Usuarios> findByLoginLike(String login) {
    // return usuariosRepo.findByLoginLike(login);

    // }

    public List<Usuarios> findByCodU(Long codu) {
        return usuariosRepo.findByCodu(codu);
    }

    public List<Usuarios> findAll(Sort sort) {
        return usuariosRepo.findAll(sort);
    }

    // /*
    // * @Override public Usuarios loadUserByUsername(String login, String password)
    // * throws UsernameNotFoundException {
    // *
    // * Usuarios usuario = usuariosRepo.findByLoginAndPassword(login,
    // * password).get(0);
    // *
    // * if (usuario == null) { throw new
    // * UsernameNotFoundException("Usuario no encontrado"); }
    // *
    // * List<GrantedAuthority> authorities = usuario.getRoles().stream() .map(role
    // ->
    // * new SimpleGrantedAuthority(role.getNombre()))
    // .collect(Collectors.toList());
    // *
    // * return new Usuarios(usuario.getLogin(), usuario.getPassword(),
    // authorities);
    // * }
    // */
}
