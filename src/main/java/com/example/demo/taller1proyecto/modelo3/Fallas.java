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
	@Column(name = "id_falla", unique = true)
	private Integer id_falla;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "nombre", nullable = false, length = 250)
	private String nombre;

}
