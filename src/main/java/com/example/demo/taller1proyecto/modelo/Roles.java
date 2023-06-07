package com.example.demo.taller1proyecto.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
@Table(name = "t_roles")
public class Roles implements Serializable {
    @Id
    @Column(name = "codr")
    @GeneratedValue(generator = "ROLES_CODR")
    Integer codr;
    @Column(name = "nombre", length = 30)
    String nombre;

    Integer estado;
    @ManyToMany
    Set<Menus> menus = new HashSet<Menus>();
    @ManyToMany
    Set<Usuarios> usuarios = new HashSet<Usuarios>();

}
