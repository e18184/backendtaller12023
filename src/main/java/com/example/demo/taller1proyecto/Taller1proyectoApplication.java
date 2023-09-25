package com.example.demo.taller1proyecto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Taller1proyectoApplication {
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(Taller1proyectoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			/*
			 * Personas person1 = new Personas(null, "4143", "Carlos", "Mata", "Copa",
			 * "sin foto", "6738", "1", 1, null, null, null, null, null); Personas person2 =
			 * new Personas(null, "4142", "Jose", "Mata", "Copa", "sin foto", "6738", "1",
			 * 1, null, null, null, null, null); personaService.save(person1);
			 * personaService.save(person2);
			 */
			System.out.println("Holaa");

		};

	}
}
