package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "ordenes_trabajo", schema = "public")
@NoArgsConstructor
@AllArgsConstructor

public class Ordenes_trabajo implements Serializable {
	@Column(name = "seq_orden_trabajo", nullable = false)
	@Id
	@GeneratedValue(generator = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_ORDENES_TRABAJO_SEQ_ORDEN_TRABAJO_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_ORDENES_TRABAJO_SEQ_ORDEN_TRABAJO_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "ordenes_trabajo_seq_orden_trabajo_seq") })
	private Integer seq_orden_trabajo;

	@Column(name = "cod_atendido", nullable = false)
	private Integer cod_atendido = Integer.valueOf(0);

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "cod_tipo_mantenimiento", nullable = false, length = 4)
	private String cod_tipo_mantenimiento;

	@Column(name = "fecha_emision", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha_emision;

	@Column(name = "numero_orden_trabajo", nullable = false, length = 50)
	private String numero_orden_trabajo;

	@Column(name = "ubicacion_activo", nullable = true, length = 250)
	private String ubicacion_activo;

	@Column(name = "seq_persona_planificante", nullable = false)
	private Integer seq_persona_planificante;

	@Column(name = "seq_solicitud_servicio", nullable = false)
	private Integer seq_solicitud_servicio;

	@ManyToMany(targetEntity = com.example.demo.taller1proyecto.modelo3.Activo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "ordenes_trabajo_activo", schema = "public", joinColumns = {
			@JoinColumn(name = "seq_orden_trabajo") }, inverseJoinColumns = { @JoinColumn(name = "seq_activo") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set seq_activo = new java.util.HashSet();

	@OneToMany(mappedBy = "seq_orden_trabajo", targetEntity = com.example.demo.taller1proyecto.modelo3.Tecnicos_ejecutantes.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set tecnicos_ejecutantes = new java.util.HashSet();
}
