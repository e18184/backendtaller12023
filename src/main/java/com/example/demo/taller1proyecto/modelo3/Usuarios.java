package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "usuarios", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuarios implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codu", unique = true)
	private Integer codu;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "usuario", nullable = true, length = 30)
	private String usuario;

	@Column(name = "contrasena", nullable = false, length = 30)
	private String contrasena;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Personas.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seq_persona", referencedColumnName = "seq_persona", nullable = false) }, foreignKey = @ForeignKey(name = "usuarios_seq_persona_fkey"))
	private com.example.demo.taller1proyecto.modelo3.Personas seq_persona;

	@ManyToMany(targetEntity = com.example.demo.taller1proyecto.modelo3.Roles.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "usuario_roles", schema = "public", joinColumns = {
			@JoinColumn(name = "usuario") }, inverseJoinColumns = { @JoinColumn(name = "id_rol") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set id_rol = new java.util.HashSet();
}
