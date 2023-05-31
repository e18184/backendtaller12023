package com.example.demo.taller1proyecto.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Menus implements Serializable {
    @Id
    @Column(name = "codm")
    @GeneratedValue(generator = "MENUS_CODM")

    Integer codm;
    @Column(name = "nombre", length = 30)
    String nombre;
    Integer estado;
    @ManyToMany
    Set<Procesos> procesos = new HashSet<Procesos>();
    @ManyToMany
    Set<Roles> roles = new HashSet<Roles>();

}