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
	@Column(name = "seq_persona", unique = true)
	private Integer seq_persona;
	@Column(name = "apellido_materno", nullable = true, length = 40)
	private String apellido_materno;

	@Column(name = "apellido_paterno", nullable = false, length = 40)
	private String apellido_paterno;

	@Column(name = "cedula_identidad", nullable = true, length = 15)
	private String cedula_identidad;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "cod_tipo", nullable = false, length = 1)
	private String cod_tipo;

	@Column(name = "fotografia", nullable = true, length = 255)
	private String fotografia;

	@Column(name = "nombres", nullable = false, length = 40)
	private String nombres;

	@Column(name = "telefono_celular", nullable = true, length = 20)
	private String telefono_celular;

	@OneToMany(mappedBy = "seq_persona_recepcionante", targetEntity = com.example.demo.taller1proyecto.modelo3.Recepciones_activo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set recepciones_activo = new java.util.HashSet();

	@OneToMany(mappedBy = "seq_persona_solicita", targetEntity = com.example.demo.taller1proyecto.modelo3.Solicitudes_servicio.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set solicitudes_servicio = new java.util.HashSet();

	@OneToMany(mappedBy = "seq_persona_ejecutante", targetEntity = com.example.demo.taller1proyecto.modelo3.Tecnicos_ejecutantes.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set tecnicos_ejecutantes = new java.util.HashSet();

	@OneToMany(mappedBy = "seq_persona", targetEntity = com.example.demo.taller1proyecto.modelo3.Usuarios.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set usuarios = new java.util.HashSet();

}
