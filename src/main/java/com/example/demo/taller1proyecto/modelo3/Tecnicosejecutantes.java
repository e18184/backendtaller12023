package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "tecnicosejecutantes", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Tecnicosejecutantes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqtecnicoejecutante", unique = true)
	private Integer seqtecnicoejecutante;

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "codresponsable", nullable = false)
	private Integer codresponsable = Integer.valueOf(0);

	@Column(name = "fechadeasignacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date fechaDeAsignacion;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Ordenestrabajo.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seqordentrabajo", referencedColumnName = "seqordentrabajo", nullable = false) }, foreignKey = @ForeignKey(name = "tecnicosejecutantesseqordentrabajofkey"))
	private com.example.demo.taller1proyecto.modelo3.Ordenestrabajo seqordentrabajo;

	@ManyToOne(targetEntity = com.example.demo.taller1proyecto.modelo3.Personas.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "seqpersonaejecutante", referencedColumnName = "seqpersona", nullable = false) }, foreignKey = @ForeignKey(name = "tecnicosejecutantesseqpersonaejecutantefkey"))
	private com.example.demo.taller1proyecto.modelo3.Personas seqpersonaejecutante;

}
