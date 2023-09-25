package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "solicitudes_servicio", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Solicitudes_servicio implements Serializable {
	@Column(name = "seq_solicitud_servicio", nullable = false)
	@Id
	@GeneratedValue(generator = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_SOLICITUDES_SERVICIO_SEQ_SOLICITUD_SERVICIO_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_SOLICITUDES_SERVICIO_SEQ_SOLICITUD_SERVICIO_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "solicitudes_servicio_seq_solicitud_servicio_seq") })
	private Integer seq_solicitud_servicio;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado;

	@Column(name = "descripcion_problema", nullable = true, length = 1500)
	private String descripcion_problema;

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Personas.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seq_persona_solicita", referencedColumnName = "seq_persona", nullable = false) }, foreignKey = @ForeignKey(name = "solicitudes_servicio_seq_persona_solicita_fkey"))
	private com.example.demo.taller1proyecto.modelo3.Personas seq_persona_solicita;

	@OneToMany(mappedBy = "seq_solicitud_servicio", targetEntity = com.example.demo.taller1proyecto.modelo3.Recepciones_activo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set recepciones_activo = new java.util.HashSet();
}
