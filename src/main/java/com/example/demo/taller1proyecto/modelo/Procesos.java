package com.example.demo.taller1proyecto.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
<<<<<<< HEAD
import jakarta.persistence.Table;
=======
>>>>>>> 505f7087c76f614141a024de8f4436c1b22bbfe8
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
// nota siempre estas clases piden un constructor como
// minimo vacio
// POJO
@Entity
<<<<<<< HEAD
// serializable persistan y se envien cookies
// utiliza para sesionar
@Table(name = "t_procesos")
public class Procesos implements Serializable {
    @Id
    @Column(name = "codp")
=======
public class Procesos implements Serializable {
    @Id
    @Column(name = "codm")
>>>>>>> 505f7087c76f614141a024de8f4436c1b22bbfe8
    @GeneratedValue(generator = "PROCESOS_CODP")
    Integer codp;
    @Column(name = "nombre", length = 30)
    String nombre;
    @Column(name = "enlace", length = 100)
    String enlace;
    @Column(name = "ayuda", length = 255)
    String ayuda;
    @Column(name = "estado")
    Integer estado;
    @ManyToMany
    Set<Menus> menus = new HashSet<Menus>();

}
