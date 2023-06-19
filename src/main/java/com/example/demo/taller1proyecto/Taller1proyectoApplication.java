package com.example.demo.taller1proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.taller1proyecto.modelo.*;
import com.example.demo.taller1proyecto.service.*;

import java.util.Set;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Taller1proyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Taller1proyectoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonaService personaService, UsuariosService usuariosService,
			ProcesosService procesosService, MenusService menusService, RolesService rolesService

	) {
		return (args) -> {
			// save few person

			Persona person1 = new Persona(null, "4143805", "Richard", "Cota", "Perez", 1, null, "casado", "M",
					"Barrio Morros Blancos", "5916649145", null, null, null);

			Persona person2 = new Persona(null, "4143805", "Ronald", "Cota", "Perez", 1, null, "casado", "M",
					"Barrio Morros Blancos", "5916649145", null, null, null);

			personaService.save(person1);
			personaService.save(person2);

			// llenar un usuario
			Usuarios usuario1 = new Usuarios(null, "uno", "uno", 1, null, person1);
			Usuarios usuario2 = new Usuarios(null, "dos", "dos", 1, null, person2);
			person1.setUsuarios(usuario1);
			usuario1.setPersona(person1);
			person2.setUsuarios(usuario2);
			usuario2.setPersona(person2);

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

			Roles rol1 = new Roles();
			rol1.setNombre("estudiante");
			// rolesService.save(rol1);

			rol1.setMenus(Set.of(menus1, menus2, menus3));
			// rol1.setUsuarios(Set.of(usuario1, usuario2));
			rolesService.save(rol1);

			Roles rol2 = new Roles();
			rol2.setNombre("docente");

			rol2.setMenus(Set.of(menus5, menus3, menus4));
			// rol2.setUsuarios(Set.of(usuario1, usuario2));
			rolesService.save(rol2);

			/*
			 * Usuarios usuario3 = new Usuarios(); usuario3.setLogin("sdfsafd");
			 * usuario3.setPassword("dsfasd"); usuario3.setEstado(0);
			 */
			try {

				if (usuariosService.usuariosFindById(Long.valueOf(usuario2.getId()))) {
					System.out.println("existe el usuario");

				} else {
					System.out.println("NO EXISTE EL USUARIO");
				}
			} catch (Exception e) {
				System.out.println("NO EXISTE EL USUARIO");
			}

			/*
			 * fetch all person System.out.println("-----List of Persons------");
			 * 
			 * for (Persona person : personaService.getPersonaList()) {
			 * System.out.println("Person Detail:" + person); }
			 */

			/* vamos hacer las relaciones de usuario a rol */

			/*
			 * List<Usuarios> pusu = usuariosService.findById(usuario1.getId());
			 * pusu.get(0).setRoles(Set.of(rol1, rol2)); usuario1 = pusu.get(0);
			 * usuariosService.save(usuario1);
			 */

			usuario1 = usuariosService.findById(usuario1.getId()).get(0);
			usuario1.setRoles(List.of(rol1, rol2));
			usuariosService.save(usuario1);
			usuario2 = usuariosService.findById(usuario2.getId()).get(0);
			usuario2.setRoles(List.of(rol1, rol2));
			usuariosService.save(usuario2);

			/*
			 * System.out.println("repository sql "); for (Usuarios usuarios :
			 * usuariosService.getUsuariosLoginPasswordSql("uno", "uno")) {
			 * System.out.println(usuarios.getLogin() + " " + usuarios.getPassword()); }
			 * 
			 * System.out.println("repository Jpsql "); for (Usuarios usuarios :
			 * usuariosService.getUsuariosLoginPasswordJpql("uno", "uno")) {
			 * System.out.println(usuarios.getLogin() + " " + usuarios.getPassword());
			 * 
			 * }
			 */

			// findByLoginAndPassword
			System.out
					.println("repository public List<Usuarios> findByLoginAndPassword(String login, String password);");
			for (Usuarios usuarios : usuariosService.findByLoginAndPassword("uno", "uno")) {
				System.out.println(
						usuarios.getPersona().getNombre() + " " + usuarios.getLogin() + " " + usuarios.getPassword());

				if (usuarios.getRoles() != null) {
					usuarios.getRoles().forEach(r -> System.out.println("rol es" + r.getNombre().toString()));
					/*
					 * for (Roles r : usuarios.getRoles()) { System.out.println("rol es" +
					 * r.getNombre().toString()); }
					 */
				}

			}
			/*
			 * // findByLoginLike System.out.
			 * println("repository public List<Usuarios> findByLoginLike(String login);");
			 * for (Usuarios usuarios : usuariosService.findByLoginLike("%o%")) {
			 * System.out.println(usuarios.getPersona().getNombre() + " " +
			 * usuarios.getPersona().getAp() + " " + usuarios.getLogin() + " " +
			 * usuarios.getPassword());
			 * 
			 * }
			 */

		};
	}

}
