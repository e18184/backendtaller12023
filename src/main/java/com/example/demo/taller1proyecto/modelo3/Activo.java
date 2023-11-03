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
	@Column(name = "seq_activo", unique = true)
	private Integer seq_activo;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "comentarios", nullable = false, length = 500)
	private String comentarios;

	@Column(name = "id_etiqueta_fisica", nullable = true, length = 100)
	private String id_etiqueta_fisica;

	@Column(name = "marca", nullable = false, length = 100)
	private String marca;

	@Column(name = "modelo", nullable = true, length = 100)
	private String modelo;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@ManyToMany(mappedBy = "seq_activo", targetEntity = com.example.demo.taller1proyecto.modelo3.Ordenes_trabajo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set seq_orden_trabajo = new java.util.HashSet();

	@OneToMany(mappedBy = "seq_activo", targetEntity = com.example.demo.taller1proyecto.modelo3.Recepciones_activo.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set recepciones_activo = new java.util.HashSet();
}
