package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "fallas", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Fallas implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfalla", unique = true)
	private Integer idfalla;

	@Column(name = "codestado", nullable = false)
	private Integer codestado = Integer.valueOf(1);

	@Column(name = "nombre", nullable = false, length = 250)
	private String nombre;

}
