package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity

@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "activo", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Activo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqactivo", unique = true)
	private Integer seqactivo;

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "comentarios", nullable = false, length = 500)
	private String comentarios;

	@Column(name = "idetiquetafisica", nullable = true, length = 100)
	private String idetiquetafisica;

	@Column(name = "marca", nullable = false, length = 100)
	private String marca;

	@Column(name = "modelo", nullable = true, length = 100)
	private String modelo;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@ManyToMany(mappedBy = "seqactivo", targetEntity = com.example.demo.taller1proyecto.modelo3.Ordenestrabajo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set seqordentrabajo = new java.util.HashSet();

	@OneToMany(mappedBy = "seqactivo", targetEntity = com.example.demo.taller1proyecto.modelo3.Recepcionesactivo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set recepcionesactivo = new java.util.HashSet();
}
