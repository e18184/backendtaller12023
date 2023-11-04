package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "tareasmantinspeccioncronologica", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Tareasmantinspeccioncronologica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqtareamantinspeccioncronologica", unique = true)
	private Integer seqtareamantinspeccioncronologica;

	@Column(name = "codejecucion", nullable = false, length = 20)
	private String codejecucion;

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "descripcion", nullable = false, length = 500)
	private String descripcion;

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	@Column(name = "fotografia", nullable = true, length = 255)
	private String fotografia;

	@Column(name = "hora", nullable = false, length = 6)
	private java.sql.Time hora;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Mantenimientoscorrectivos.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seqmantenimientocorrectivo", referencedColumnName = "seqmantenimientocorrectivo", nullable = false) }, foreignKey = @ForeignKey(name = "tareasmantinspeccioncronolseqmantenimientocorrectivofkey"))
	private com.example.demo.taller1proyecto.modelo3.Mantenimientoscorrectivos seqmantenimientocorrectivo;
}
