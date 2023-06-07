package com.example.demo.taller1proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "t_usuarios")
public class Usuarios implements Serializable {
    @Id
    @Column(name = "codu")
    @GeneratedValue(generator = "USUARIO_CODU")
    Integer id;
    @Column(name = "login", length = 30)
    String login;
    @Column(name = "password", length = 30)
    String password;
    Integer estado;
    @ManyToMany
    Set<Roles> roles = new HashSet<Roles>();
    @OneToOne
    Persona persona;

}
