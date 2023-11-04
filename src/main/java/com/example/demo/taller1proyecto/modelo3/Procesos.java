package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "procesos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Procesos implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codp", unique = true)
	private Integer codP;

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
