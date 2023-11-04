package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "recepcionesactivo", schema = "public")
@NoArgsConstructor
@AllArgsConstructor

public class Recepcionesactivo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqrecepcionactivo", unique = true)
	private Integer seqrecepcionActivo;

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Activo.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seqactivo", referencedColumnName = "seqactivo", nullable = false) }, foreignKey = @ForeignKey(name = "recepcionesactivoseqactivofkey"))
	private com.example.demo.taller1proyecto.modelo3.Activo seqactivo;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Personas.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seqpersonarecepcionante", referencedColumnName = "seqpersona", nullable = false) }, foreignKey = @ForeignKey(name = "recepcionesactivoseqpersonarecepcionantefkey"))
	private com.example.demo.taller1proyecto.modelo3.Personas seqpersonarecepcionante;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Solicitudeservicio.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seqsolicitudservicio", referencedColumnName = "seqsolicitudservicio", nullable = false) }, foreignKey = @ForeignKey(name = "recepcionesactivoseqsolicitudserviciofkey"))
	private com.example.demo.taller1proyecto.modelo3.Solicitudeservicio seqsolicitudservicio;
}
