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
	@Column(name = "id_falla", nullable = false)
	@Id
	@GeneratedValue(generator = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_FALLAS_ID_FALLA_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_EXAMPLE_DEMO_TALLER1PROYECTO_MODELO3_FALLAS_ID_FALLA_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "fallas_id_falla_seq") })
	private Integer id_falla;

	@Column(name = "cod_estado", nullable = false)
	private Integer cod_estado = Integer.valueOf(1);

	@Column(name = "nombre", nullable = false, length = 250)
	private String nombre;

}
