package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "tecnicos_ejecutantes", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Tecnicos_ejecutantes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_tecnico_ejecutante", unique = true)
	private Integer seq_tecnico_ejecutante;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "cod_responsable", nullable = false)
	private Integer cod_responsable = Integer.valueOf(0);

	@Column(name = "fecha_de_asignacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha_de_asignacion;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Ordenes_trabajo.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seq_orden_trabajo", referencedColumnName = "seq_orden_trabajo", nullable = false) }, foreignKey = @ForeignKey(name = "tecnicos_ejecutantes_seq_orden_trabajo_fkey"))
	private com.example.demo.taller1proyecto.modelo3.Ordenes_trabajo seq_orden_trabajo;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Personas.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seq_persona_ejecutante", referencedColumnName = "seq_persona", nullable = false) }, foreignKey = @ForeignKey(name = "tecnicos_ejecutantes_seq_persona_ejecutante_fkey"))
	private com.example.demo.taller1proyecto.modelo3.Personas seq_persona_ejecutante;

}
