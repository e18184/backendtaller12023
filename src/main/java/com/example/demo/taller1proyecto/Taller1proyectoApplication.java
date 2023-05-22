package com.example.demo.taller1proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.taller1proyecto.modelo.Persona;
import com.example.demo.taller1proyecto.service.PersonaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Taller1proyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Taller1proyectoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonaService personaService) {
		return (args) -> {
			// save few person

			Persona person1 = new Persona();
			person1.setNombre("Richard");
			person1.setAm("perez");
			person1.setAp("Cota");
			person1.setCedula("4143805");
			person1.setEcivil("casado");
			person1.setEstado(1);
			person1.setFoto("sin foto");

			Persona person2 = new Persona();
			person2.setNombre("Ronald");
			person2.setAm("perez");
			person2.setAp("Cota");
			person2.setCedula("4143810");
			person1.setEcivil("soltero");
			person1.setEstado(1);
			person1.setFoto("sin foto");

			personaService.save(person1);
			personaService.save(person2);

			// fetch all person
			System.out.println("-----List of Persons------");
			for (Persona person : personaService.getPersonaList()) {
				System.out.println("Person Detail:" + person);
			}
		};
	}

}
