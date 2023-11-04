package com.example.demo.taller1proyecto.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_menus")
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
    @ManyToMany(mappedBy = "menus", fetch = FetchType.EAGER)
    // Set<Roles> roles = new HashSet<Roles>();
    List<Roles> roles;
}