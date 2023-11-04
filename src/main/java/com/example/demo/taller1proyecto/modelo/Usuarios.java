package com.example.demo.taller1proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_usuarios")
@Data
public class Usuarios implements Serializable {
        @Id
        @Column(name = "codu")
        @GeneratedValue(generator = "USUARIOS_CODU")
        Integer id;
        @Column(name = "login", length = 30, unique = true)
        String login;
        @Column(name = "password", length = 30)
        String password;
        Integer estado;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuarios_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
        List<Roles> roles;

        @OneToOne
        Persona persona;

}
