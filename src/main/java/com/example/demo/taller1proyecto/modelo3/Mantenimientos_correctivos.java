package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "mantenimientos_correctivos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Mantenimientos_correctivos implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_mantenimiento_correctivo", unique = true)
	private Integer seq_mantenimiento_correctivo;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "cod_tipo_solucion", nullable = false, length = 60)
	private String cod_tipo_solucion;

	@Column(name = "comentario_deteccion_falla", nullable = false, length = 1500)
	private String comentario_deteccion_falla;

	@Column(name = "comentarios", nullable = false, length = 2500)
	private String comentarios;

	@Column(name = "descripcion_causa", nullable = true, length = 1500)
	private String descripcion_causa;

	@Column(name = "descripcion_solucion", nullable = true, length = 1500)
	private String descripcion_solucion;

	@Column(name = "duracion", nullable = false, length = 90)
	private String duracion;

	@Column(name = "fecha_finalizacion", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha_finalizacion;

	@Column(name = "id_falla", nullable = false)
	private Integer id_falla;

	@Column(name = "seq_activo", nullable = false)
	private Integer seq_activo;

	@Column(name = "seq_orden_trabajo", nullable = false)
	private Integer seq_orden_trabajo;

	@OneToMany(mappedBy = "seq_mantenimiento_correctivo", targetEntity = com.example.demo.taller1proyecto.modelo3.Tareas_mant_inspeccion_cronologica.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set tareas_mant_inspeccion_cronologica = new java.util.HashSet();
}
