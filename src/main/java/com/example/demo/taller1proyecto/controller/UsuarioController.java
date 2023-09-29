package com.example.demo.taller1proyecto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.taller1proyecto.service.UsuariosService;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

// import com.example.demo.taller1proyecto.dto.UsuarioDTO;

import com.example.demo.taller1proyecto.modelo3.Usuarios;

@RestController
@RequestMapping("/usuariocontroller")
public class UsuarioController {
    @Autowired
    UsuariosService usuarioService;

    @GetMapping("/")
    public ResponseEntity<List<Usuarios>> findAll() {
        try {
            Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "usuario").ignoreCase());
            List<Usuarios> usuarios = usuarioService.findAll(sortBy);
            // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Usuarios usuario : usuarios) {
                usuario.setId_rol(null);

            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Usuarios>> find(@PathVariable Integer id) {
        try {
            List<Usuarios> usuarios = usuarioService.findByCodU(id);
            // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Usuarios usuario : usuarios) {
                usuario.setId_rol(null);

            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/dto")
    // public ResponseEntity<List<UsuarioDTO>> findAll() {
    // try {

    // // consulta en sql
    // // SELECT
    // // u.login, u.password, p.nombre, r.nombre
    // // FROM
    // // t_persona p, t_usuarios u, usuarios_roles ur,
    // // t_roles r
    // // WHERE
    // // p.codu = u.codu AND
    // // u.codu=ur.usuarios_id
    // // AND
    // // ur.roles_id = r.codr;
    // Sort sort = Sort.by(Sort.Direction.ASC, "login");

    // List<Usuarios> usuarios = usuarioService.findAll(sort);
    // List<UsuarioDTO> usuariosDTO = new ArrayList<>();

    // for (Usuarios usuario : usuarios) {
    // UsuarioDTO usuarioDTO = new UsuarioDTO();
    // // asignando al DTO los datos
    // usuarioDTO.setLogin(usuario.getLogin());
    // usuarioDTO.setPassword(usuario.getPassword());
    // // nombre de la persona
    // usuarioDTO.setNombre(usuario.getPersona().getNombre());
    // // rol de la persona
    // // usuarioDTO.getNombreRol(usuario.getRoles().forEach(a->);)
    // // String[] array = usuario.getRoles().stream().toArray(String[]::new);

    // // usuarioDTO.setNombreRol(usuario.getRoles());

    // usuariosDTO.add(usuarioDTO);
    // }

    // return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);

    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // // seleccionar un usuario en base a un login y password

    @GetMapping("/{usuario}/{contrasena}")
    public ResponseEntity<List<Usuarios>> find(@PathVariable String usuario, @PathVariable String contrasena) {
        try {
            List<Usuarios> usuarios = usuarioService.findByUsuarioAndContrasena(usuario, contrasena);
            // // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Usuarios usuarioss : usuarios) {
                usuarioss.setId_rol(null);
            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // // realizar un metodo para devolver los roles asociados al usuario
    // // findById(Integer id)
    // // Clase Rol
    // // salida
    // // los roles que tiene un usuario
    // // ejemplo:
    // // nombre rol
    // // docente
    // // estudiante
    // /*
    // * @PostMapping("/login") public ResponseEntity<String> login(@RequestBody
    // * Usuarios usuarios) { String login = usuarios.getLogin(); String password =
    // * usuarios.getPassword();
    // *
    // * List<Usuarios> usuariosList = usuarioService.findByLoginAndPassword(login,
    // * password);
    // *
    // * if (!usuariosList.isEmpty()) { // Usuario válido, guardar la información
    // del
    // * usuario en el contexto de // seguridad Usuarios userDetails =
    // * usuarioService.buildUserDetails(usuariosList.get(0)); Authentication
    // * authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
    // * userDetails.getAuthorities());
    // * SecurityContextHolder.getContext().setAuthentication(authentication);
    // *
    // * return ResponseEntity.ok("Inicio de sesión exitoso"); } else { // Usuario o
    // * contraseña incorrectos return
    // * ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales
    // inválidas"
    // * ); } }
    // */
}
