package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "mantenimientoscorrectivos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Mantenimientoscorrectivos implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqmantenimientocorrectivo", unique = true)
	private Integer seqmantenimientocorrectivo;

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "codtiposolucion", nullable = false, length = 60)
	private String codtiposolucion;

	@Column(name = "comentariodeteccionfalla", nullable = false, length = 1500)
	private String comentariodeteccionfalla;

	@Column(name = "comentarios", nullable = false, length = 2500)
	private String comentarios;

	@Column(name = "descripcioncausa", nullable = true, length = 1500)
	private String descripcioncausa;

	@Column(name = "descripcionsolucion", nullable = true, length = 1500)
	private String descripcionsolucion;

	@Column(name = "duracion", nullable = false, length = 90)
	private String duracion;

	@Column(name = "fechafinalizacion", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date fechafinalizacion;

	@Column(name = "idfalla", nullable = false)
	private Integer idfalla;

	@Column(name = "seqactivo", nullable = false)
	private Integer seqactivo;

	@Column(name = "seqordentrabajo", nullable = false)
	private Integer seqordentrabajo;

	@OneToMany(mappedBy = "seqmantenimientocorrectivo", targetEntity = com.example.demo.taller1proyecto.modelo3.Tareasmantinspeccioncronologica.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set tareasmantinspeccioncronologica = new java.util.HashSet();
}
