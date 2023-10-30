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
	@Column(name = "id_rol", unique = true)
	private Integer id_rol;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "nombre", nullable = false, length = 40)
	private String nombre;

	@ManyToMany(targetEntity = com.example.demo.taller1proyecto.modelo3.Menus.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "rolme", schema = "public", joinColumns = { @JoinColumn(name = "codr") }, inverseJoinColumns = {
			@JoinColumn(name = "codm") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set codm = new java.util.HashSet();

	@ManyToMany(mappedBy = "id_rol", targetEntity = com.example.demo.taller1proyecto.modelo3.Usuarios.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set usuario = new java.util.HashSet();
}
