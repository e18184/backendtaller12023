package com.example.demo.taller1proyecto.modelo;

// com.example.demo.taller1proyecto.
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
// serializable persistan y se envien cookies
// utiliza para sesionar
public class Prueba implements Serializable {
    @Id
    @Column(name = "codp")
    @GeneratedValue(generator = "PRUEBA_CODP")
    Integer codp;
    @Column(name = "nombre", length = 30)
    String nombre;
    @Column(name = "enlace", length = 100)
    String enlace;
    @Column(name = "ayuda", length = 255)
    String ayuda;
    @Column(name = "estado")
    Integer estado;
}
