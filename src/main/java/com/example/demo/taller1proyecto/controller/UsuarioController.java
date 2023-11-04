package com.example.demo.taller1proyecto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.taller1proyecto.service.UsuariosService;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.taller1proyecto.dto.UsuarioDTO;
import com.example.demo.taller1proyecto.modelo.Usuarios;

@RestController
@RequestMapping("/usuariocontroller")
public class UsuarioController {
    @Autowired
    UsuariosService usuarioService;

    /*
     * @GetMapping() public ResponseEntity<List<Usuarios>> findAll() { try { //
     * modifique List<Usuarios> usuarios = usuarioService.findAll();
     * 
     * for (Usuarios usuario : usuarios) { usuario.setRoles(null);
     * 
     * }
     * 
     * return new ResponseEntity<>(usuarios, HttpStatus.OK);
     * 
     * } catch (Exception e) { return new
     * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<Usuarios>> find(@PathVariable Integer id) {
        try {
            List<Usuarios> usuarios = usuarioService.findById(id);
            // Iterar sobre la lista de usuarios y establecer las relaciones a null
            for (Usuarios usuario : usuarios) {
                usuario.setRoles(null);

            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dto")
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        try {
            Sort sort = Sort.by(Sort.Direction.ASC, "login");

            List<Usuarios> usuarios = usuarioService.findAll(sort);
            List<UsuarioDTO> usuariosDTO = new ArrayList<>();

            for (Usuarios usuario : usuarios) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                // asignando al DTO los datos
                usuarioDTO.setLogin(usuario.getLogin());
                usuarioDTO.setPassword(usuario.getPassword());
                // Establece otras propiedades/columnas que deseas mostrar

                usuariosDTO.add(usuarioDTO);
            }

            return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
