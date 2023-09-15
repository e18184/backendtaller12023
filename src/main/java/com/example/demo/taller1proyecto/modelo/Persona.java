package com.example.demo.taller1proyecto.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.Comment;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_persona")
@Comment("Representa la Entidad Persona")
public class Persona implements Serializable {
    @Id
    @Column(name = "codu")
    @GeneratedValue(generator = "USUARIO_CODR")
    Integer codp;

    @Column(name = "cedula_identidad", length = 15, nullable = true)
    @Comment("Cedula de la identidad de la persona")
    String cedula;

    @Column(name = "nombres", length = 40, nullable = false)
    @Comment("Nombre de la persona")
    String nombre;

    @Column(name = "apellido_paterno", length = 40, nullable = false)
    @Comment("Apellido paterno de la persona")
    String ap;

    @Column(name = "apellido_materno", length = 40, nullable = false)
    @Comment("Apellido materno de la persona")
    String am;

    @Comment("Si esta activo o no la persona")
    Integer estado;

    @Comment("Fecha de nacimiento de la persona")
    Date fec;

    @Comment("Estado civil de la persona")
    String ecivil;

    @Comment("genero de la persona 0= femenino 1=masculino")
    String genero;

    @Comment("direcion de la persona")
    String direc;

    @Column(name = "telefono_celular", length = 20, nullable = false)
    @Comment("Telefono o celular de la persona")
    String telef;

    @Column(name = "cod_tipo", length = 1, nullable = true)
    @org.hibernate.annotations.ColumnDefault("1")
    @Comment("parametrico de estado 1(ACTIVO) 0(INACTIVO)")
    Integer tipo;

    @Column(name = "fotografia", length = 255, nullable = true)
    @Comment("Fotografia de la persona")
    String foto;

    @OneToOne
    @Comment("Relacion de uno a uno con los datos de un usuario")
    Usuarios usuarios;

    @OneToMany
    @Comment("Persona puede tener muchas solicitudes de servicio")
    List<SolicitudesServicio> solicitudesservicio;

}
