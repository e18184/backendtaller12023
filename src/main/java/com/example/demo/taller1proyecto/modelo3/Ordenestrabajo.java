package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "ordenestrabajo", schema = "public")
@NoArgsConstructor
@AllArgsConstructor

public class Ordenestrabajo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqordentrabajo", unique = true)
	private Integer seqordentrabajo;

	@Column(name = "codatendido", nullable = false)
	private Integer codatendido = Integer.valueOf(0);

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "codtipomantenimiento", nullable = false, length = 4)
	private String codtipomantenimiento;

	@Column(name = "fechaemision", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fechaemision;

	@Column(name = "numeroordentrabajo", nullable = false, length = 50)
	private String numeroordentrabajo;

	@Column(name = "ubicacionactivo", nullable = true, length = 250)
	private String ubicacionactivo;

	@Column(name = "seqpersonaplanificante", nullable = false)
	private Integer seqpersonaplanificante;

	@Column(name = "seqsolicitudservicio", nullable = false)
	private Integer seqsolicitudservicio;

	@ManyToMany(targetEntity = com.example.demo.taller1proyecto.modelo3.Activo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "ordenestrabajoactivo", schema = "public", joinColumns = {
			@JoinColumn(name = "seqordentrabajo") }, inverseJoinColumns = { @JoinColumn(name = "seqactivo") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set seqactivo = new java.util.HashSet();

	@OneToMany(mappedBy = "seqordentrabajo", targetEntity = com.example.demo.taller1proyecto.modelo3.Tecnicosejecutantes.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set tecnicosejecutantes = new java.util.HashSet();
}
