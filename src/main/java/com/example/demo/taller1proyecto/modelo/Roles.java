package com.example.demo.taller1proyecto.modelo;

import java.io.Serializable;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_menu", joinColumns = @JoinColumn(name = "roles_id"), inverseJoinColumns = @JoinColumn(name = "menus_id"))
    // Set<Menus> menus = new HashSet<Menus>();
    List<Menus> menus;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    List<Usuarios> usuarios;

}
