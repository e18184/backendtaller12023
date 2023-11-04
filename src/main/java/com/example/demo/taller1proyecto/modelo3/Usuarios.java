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

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "usuario", nullable = true, length = 30)
	private String usuario;

	@Column(name = "contrasena", nullable = false, length = 30)
	private String contrasena;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Personas.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seqpersona", referencedColumnName = "seqpersona", nullable = false) }, foreignKey = @ForeignKey(name = "usuariosseqpersonafkey"))
	private com.example.demo.taller1proyecto.modelo3.Personas seqpersona;

	@ManyToMany(targetEntity = com.example.demo.taller1proyecto.modelo3.Roles.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "usuarioroles", schema = "public", joinColumns = {
			@JoinColumn(name = "usuario") }, inverseJoinColumns = { @JoinColumn(name = "idrol") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set idrol = new java.util.HashSet();
}
