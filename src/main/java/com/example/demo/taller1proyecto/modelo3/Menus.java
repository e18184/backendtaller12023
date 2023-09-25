package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "menus", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Menus implements Serializable {
	@Column(name = "codm", nullable = false)
	@Id
	@GeneratedValue(generator = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_MENUS_CODM_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_MENUS_CODM_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "menus_codm_seq") })
	private Integer codm;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@Column(name = "nombre", nullable = false, length = 40)
	private String nombre;

	@ManyToMany(mappedBy = "codm", targetEntity = com.example.demo.taller1proyecto.modelo3.Procesos.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set codp = new java.util.HashSet();

	@ManyToMany(mappedBy = "codm", targetEntity = com.example.demo.taller1proyecto.modelo3.Roles.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set codr = new java.util.HashSet();
}
