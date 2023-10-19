package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "procesos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor

public class Procesos implements Serializable {
	@Column(name = "codp", nullable = false)
	@Id
	@GeneratedValue(generator = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_PROCESOS_CODP_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_PROCESOS_CODP_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "procesos_codp_seq") })
	private Integer codp;

	@Column(name = "enlace", nullable = false, length = 60)
	private String enlace;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@Column(name = "nombre", nullable = false, length = 40)
	private String nombre;

	@ManyToMany(targetEntity = com.example.demo.taller1proyecto.modelo3.Menus.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "mepro", schema = "public", joinColumns = { @JoinColumn(name = "codp") }, inverseJoinColumns = {
			@JoinColumn(name = "codm") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set codm = new java.util.HashSet();

}
