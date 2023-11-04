// package com.example.demo.taller1proyecto.modelo;

// import java.io.Serializable;
// import java.util.Date;

// import org.hibernate.annotations.Comment;

// import lombok.*;
// import jakarta.persistence.Column;
// import jakarta.persistence.Table;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToOne;

// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// @Table(name = "tusuarios")
// @Comment("Datos del usuario")
// @Data
// public class SolicitudesServicio implements Serializable {
// @Id
// @Column(name = "codu")
// @GeneratedValue(generator = "SOLICITUDESSERVICIOCODU")
// @Comment("Sequencia de Solicitud de Servicio")
// Integer id;

// @Column(name = "fecha")
// @Comment("Fecha de Solicitud de Servicio")
// Date fecha;

// @Column(name = "descripcionproblema", length = 250)
// @Comment("Descripcion de problema de solicitud de servicio")
// String descripcionproblema;

// @Comment("Si esta activo o no el usuario")
// Integer estado;

// @OneToOne
// @Comment("Se relaciona con una persona")
// Persona persona;

// }
