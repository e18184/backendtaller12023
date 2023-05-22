package com.example.demo.taller1proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Usuarios implements Serializable {
    @Id
    @Column(name = "codu")
    @GeneratedValue(generator = "USUARIO_CODR")
    Integer id;
    @Column(name = "nombre", length = 30)
    String login;
    @Column(name = "passsword", length = 30)
    String password;
    Integer estado;
    @ManyToMany
    Set<Roles> roles = new HashSet<Roles>();
    @OneToOne
    Persona persona;

}
