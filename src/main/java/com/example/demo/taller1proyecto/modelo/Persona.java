package com.example.demo.taller1proyecto.modelo;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {
    @Id
    @Column(name = "codu")
    @GeneratedValue(generator = "USUARIO_CODR")
    Integer codp;
    String cedula;
    String nombre;
    String ap;
    String am;
    Integer estado;
    Date fec;
    String ecivil;
    String genero;
    String direc;
    String telef;
    String tipo;
    String foto;
    @OneToOne
    Usuarios usuarios;

}
