package com.example.demo.taller1proyecto.dto;

import lombok.*;
import java.util.List;

import com.example.demo.taller1proyecto.modelo.Roles;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    // clase Usuario
    private String login;
    private String password;
    // clase Persona
    private String nombre;
    // clase Rol
    private List<Roles> nombreRol = new ArrayList<>();

}
