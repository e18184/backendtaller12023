package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "tareas_mant_inspeccion_cronologica", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Tareas_mant_inspeccion_cronologica implements Serializable {

	@Column(name = "seq_tarea_mant_inspeccion_cronologica", nullable = false)
	@Id
	@GeneratedValue(generator = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_TAREAS_MANT_INSPECCION_CRONOLOGICA_SEQ_TAREA_MANT_INSPECCION_CRONOLOGICA_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_TAREAS_MANT_INSPECCION_CRONOLOGICA_SEQ_TAREA_MANT_INSPECCION_CRONOLOGICA_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "tareas_mant_inspeccion_cronol_seq_tarea_mant_inspeccion_cro_seq") })
	private Integer seq_tarea_mant_inspeccion_cronologica;

	@Column(name = "cod_ejecucion", nullable = false, length = 20)
	private String cod_ejecucion;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "descripcion", nullable = false, length = 500)
	private String descripcion;

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	@Column(name = "fotografia", nullable = true, length = 255)
	private String fotografia;

	@Column(name = "hora", nullable = false, length = 6)
	private java.sql.Time hora;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Mantenimientos_correctivos.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seq_mantenimiento_correctivo", referencedColumnName = "seq_mantenimiento_correctivo", nullable = false) }, foreignKey = @ForeignKey(name = "tareas_mant_inspeccion_cronol_seq_mantenimiento_correctivo_fkey"))
	private com.example.demo.taller1proyecto.modelo3.Mantenimientos_correctivos seq_mantenimiento_correctivo;
}
