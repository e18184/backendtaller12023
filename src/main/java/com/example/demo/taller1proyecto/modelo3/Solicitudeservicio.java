package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "solicitudesservicio", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Solicitudeservicio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqsolicitudservicio", unique = true)
	private Integer seqsolicitudServicio;

	@Column(name = "codestado", nullable = false)
	private Integer codestado;

	@Column(name = "descripcionproblema", nullable = true, length = 1500)
	private String descripcionproblema;

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Personas.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seqpersonasolicita", referencedColumnName = "seqpersona", nullable = false) }, foreignKey = @ForeignKey(name = "solicitudesservicioseqpersonasolicitafkey"))
	private com.example.demo.taller1proyecto.modelo3.Personas seqpersonasolicita;

	@OneToMany(mappedBy = "seqsolicitudservicio", targetEntity = com.example.demo.taller1proyecto.modelo3.Recepcionesactivo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set recepcionesactivo = new java.util.HashSet();
}
