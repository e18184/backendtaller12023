package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "roles", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Roles implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol", unique = true)
	private Integer idrol;

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "nombre", nullable = false, length = 40)
	private String nombre;

	@ManyToMany(targetEntity = com.example.demo.taller1proyecto.modelo3.Menus.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "rolme", schema = "public", joinColumns = { @JoinColumn(name = "codr") }, inverseJoinColumns = {
			@JoinColumn(name = "codm") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set codm = new java.util.HashSet();

	@ManyToMany(mappedBy = "idrol", targetEntity = com.example.demo.taller1proyecto.modelo3.Usuarios.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set usuario = new java.util.HashSet();
}
