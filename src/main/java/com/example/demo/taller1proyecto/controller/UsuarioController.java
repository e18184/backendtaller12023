package com.example.demo.taller1proyecto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.taller1proyecto.service.UsuariosService;
import org.springframework.data.domain.Sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import com.example.demo.taller1proyecto.dto.UsuarioDTO;

import com.example.demo.taller1proyecto.modelo3.Usuarios;

@RestController
@RequestMapping("usuariocontroller")
public class UsuarioController {
    @Autowired
    UsuariosService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> findAll() {
        try {
            Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "usuario").ignoreCase());
            List<Usuarios> usuarios = usuarioService.findAll(sortBy);
            // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Usuarios usuario : usuarios) {
                usuario.setIdrol(null);

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

                usuario.setIdrol(null);

                // usuario.getRoles() Set

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
    // // tpersona p, tusuarios u, usuariosroles ur,
    // // troles r
    // // WHERE
    // // p.codu = u.codu AND
    // // u.codu=ur.usuariosid
    // // AND
    // // ur.rolesid = r.codr;
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
    // return new ResponseEntity<>(HttpStatus.INTERNALSERVERERROR);
    // }
    // }

    // // seleccionar un usuario en base a un login y password

    @GetMapping("/{usuario}/{contrasena}")
    public ResponseEntity<List<Usuarios>> find(@PathVariable String usuario, @PathVariable String contrasena) {
        try {
            List<Usuarios> usuarios = usuarioService.findByUsuarioAndContrasena(usuario, contrasena);
            // // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Usuarios usuarioss : usuarios) {
                usuarioss.setIdrol(null);
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
    @PostMapping
    public String usuario(@RequestBody Usuarios usuarios) {
        System.out.println("usuario:" + usuarios.getUsuario() + "contrasena: " + usuarios.getContrasena());
        List<Usuarios> lista = usuarioService.findByUsuarioAndContrasena(usuarios.getUsuario(),
                usuarios.getContrasena());
        if (lista != null && !lista.isEmpty()) {
            Usuarios u = (Usuarios) lista.get(0);
            System.out.println("Ok");
            return "OK";
        } else
            System.out.println("KO");
        return "KO";

    }

    // @PostMapping("/auth")
    // @CrossOrigin(origins = "http://localhost:8081")
    // public ResponseEntity<String> authenticate(@RequestHeader("Authorization")
    // String authHeader) {
    // // Verifica la autenticación básica aquí.
    // if (isValidCredentials(authHeader)) {
    // return new ResponseEntity<>("OK", HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>("KO", HttpStatus.UNAUTHORIZED);
    // }
    // }

    // private boolean isValidCredentials(String authHeader) {
    // // Extrae el usuario y la contraseña del encabezado de autorización.
    // String base64Credentials = authHeader.substring("Basic".length()).trim();
    // String credentials = new
    // String(Base64.getDecoder().decode(base64Credentials));
    // String[] parts = credentials.split(":", 2);

    // // Verifica las credenciales aquí (por ejemplo, consulta tu base de datos).
    // String username = parts[0];
    // String password = parts[1];

    // // Realiza la lógica de verificación, como verificar en la base de datos o en
    // // algún otro sistema de autenticación.
    // // Retorna true si las credenciales son válidas, de lo contrario, false.

    // return username.equals("usuario") && password.equals("contrasena");
    // }
}
