package com.example.demo.taller1proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.taller1proyecto.modelo.*;
import com.example.demo.taller1proyecto.service.*;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Taller1proyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Taller1proyectoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonaService personaService, UsuariosService usuariosService,
			ProcesosService procesosService, MenusService menusService

	) {
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
			person2.setEcivil("soltero");
			person2.setEstado(1);
			person2.setFoto("sin foto");

			personaService.save(person1);
			personaService.save(person2);

			// llenar un usuario
			Usuarios usuario1 = new Usuarios();
			usuario1.setLogin("uno");
			usuario1.setPassword("uno");
			usuario1.setEstado(1);

			Usuarios usuario2 = new Usuarios();
			usuario2.setLogin("uno");
			usuario2.setPassword("uno");
			usuario2.setEstado(1);

			person2.setUsuarios(usuario2);
			usuario2.setPersona(person2);

			person1.setUsuarios(usuario1);
			usuario1.setPersona(person1);

			usuariosService.save(usuario1);
			usuariosService.save(usuario2);

			// Procesos procesos1 = new Procesos();
			Procesos procesos1 = new Procesos(null, "Proceso1", "index", "sin ayuda", 1, null);
			Procesos procesos2 = new Procesos(null, "Proceso2", "index", "sin ayuda", 1, null);
			Procesos procesos3 = new Procesos(null, "Proceso3", "index", "sin ayuda", 1, null);

			Menus menus1 = new Menus(null, "menu1", 1, null, null);
			menusService.save(menus1);
			Menus menus2 = new Menus(null, "menu2", 1, null, null);
			menusService.save(menus2);
			Menus menus3 = new Menus(null, "menu3", 1, null, null);
			menusService.save(menus3);
			Menus menus4 = new Menus(null, "menu4", 1, null, null);
			menusService.save(menus4);
			Menus menus5 = new Menus(null, "menu5", 1, null, null);
			menusService.save(menus5);
			Menus menus6 = new Menus(null, "menu6", 1, null, null);
			menusService.save(menus6);
			/*
			 * procesos1.setMenus(Set.of(menus1, menus2)); procesos2.setMenus(Set.of(menus3,
			 * menus4)); procesos3.setMenus(Set.of(menus5, menus6));
			 */

			// como relacionar un procesos con varios menus
			/*
			 * 1ra forma Set<Menus> listamenus = new HastSet<Menus>();
			 * listamenus.add(menu1); listamenus.add(menu2); procesos1.setMenus(listamenus);
			 */
			/*
			 * 2da forma procesos1.setMenus(Set<Menus>.of(menu1,menu2,menu3));
			 * 
			 */

			procesos1.setMenus(Set.of(menus1, menus2));
			procesosService.save(procesos1);
			procesos2.setMenus(Set.of(menus3, menus4));
			procesosService.save(procesos2);
			procesos3.setMenus(Set.of(menus5, menus6));
			procesosService.save(procesos3);

			// fetch all person
			System.out.println("-----List of Persons------");
			for (Persona person : personaService.getPersonaList()) {
				System.out.println("Person Detail:" + person);
			}
		};
	}

}
