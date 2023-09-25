package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "recepciones_activo", schema = "public")
@NoArgsConstructor
@AllArgsConstructor

public class Recepciones_activo implements Serializable {
	@Column(name = "seq_recepcion_activo", nullable = false)
	@Id
	@GeneratedValue(generator = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_RECEPCIONES_ACTIVO_SEQ_RECEPCION_ACTIVO_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_RECEPCIONES_ACTIVO_SEQ_RECEPCION_ACTIVO_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "recepciones_activo_seq_recepcion_activo_seq") })
	private Integer seq_recepcion_activo;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Activo.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seq_activo", referencedColumnName = "seq_activo", nullable = false) }, foreignKey = @ForeignKey(name = "recepciones_activo_seq_activo_fkey"))
	private com.example.demo.taller1proyecto.modelo3.Activo seq_activo;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Personas.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seq_persona_recepcionante", referencedColumnName = "seq_persona", nullable = false) }, foreignKey = @ForeignKey(name = "recepciones_activo_seq_persona_recepcionante_fkey"))
	private com.example.demo.taller1proyecto.modelo3.Personas seq_persona_recepcionante;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Solicitudes_servicio.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seq_solicitud_servicio", referencedColumnName = "seq_solicitud_servicio", nullable = false) }, foreignKey = @ForeignKey(name = "recepciones_activo_seq_solicitud_servicio_fkey"))
	private com.example.demo.taller1proyecto.modelo3.Solicitudes_servicio seq_solicitud_servicio;
}
