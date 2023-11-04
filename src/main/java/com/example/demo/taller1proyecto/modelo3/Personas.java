package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "personas", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personas implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqpersona", unique = true)
	private Integer seqpersona;
	@Column(name = "apellidomaterno", nullable = true, length = 40)
	private String apellidomaterno;

	@Column(name = "apellidopaterno", nullable = false, length = 40)
	private String apellidopaterno;

	@Column(name = "cedulaidentidad", nullable = true, length = 15)
	private String cedulaidentidad;

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "codtipo", nullable = false, length = 1)
	private String codtipo;

	@Column(name = "fotografia", nullable = true, length = 255)
	private String fotografia;

	@Column(name = "nombres", nullable = false, length = 40)
	private String nombres;

	@Column(name = "telefonocelular", nullable = true, length = 20)
	private String telefonocelular;

	@OneToMany(mappedBy = "seqpersonarecepcionante", targetEntity = com.example.demo.taller1proyecto.modelo3.Recepcionesactivo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set recepcionesactivo = new java.util.HashSet();

	@OneToMany(mappedBy = "seqpersonasolicita", targetEntity = com.example.demo.taller1proyecto.modelo3.Solicitudeservicio.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set solicitudesservicio = new java.util.HashSet();

	@OneToMany(mappedBy = "seqpersonaejecutante", targetEntity = com.example.demo.taller1proyecto.modelo3.Tecnicosejecutantes.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set tecnicosejecutantes = new java.util.HashSet();

	@OneToMany(mappedBy = "seqpersona", targetEntity = com.example.demo.taller1proyecto.modelo3.Usuarios.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set usuarios = new java.util.HashSet();

}
