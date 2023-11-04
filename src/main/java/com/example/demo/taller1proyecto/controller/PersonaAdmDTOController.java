/*
 * package com.example.demo.taller1proyecto.controller;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * 
 * import com.example.demo.taller1proyecto.dto.PersonaAdmDTO; import
 * com.example.demo.taller1proyecto.service.PersonaAdmDTOService; import
 * com.example.demo.taller1proyecto.service.RolesService;
 * 
 * @RestController
 * 
 * @RequestMapping("/personadmdtocontroller") public class
 * PersonaAdmDTOController {
 * 
 * 
 * PersonaAdmDTOService personaAdmDTOService;
 * 
 * @GetMapping(" ") public ResponseEntity<PersonaAdmDTO>
 * findPersonaAdmDTO(@PathVariable String buscar, @PathVariable String
 * tipo, @PathVariable int estado) { try {
 * 
 * //tipo %=todos 1=cliente 2=recpcionista // estado %=todos 0=inactivo
 * 1=activos List<PersonaAdmDTO> personas =
 * personaAdmDTOService.findBySearchString(buscar,tipo,estado);
 * List<PersonaAdmDTO> usuariosroles = new ArrayList<>();
 * 
 * // Iterar sobre la lista de usuarios y establecer las relaciones a null for
 * (Roles roles : usuarios) { Roles usuariorol = new Roles();
 * usuariorol.setNombre(roles.getNombre()); usuariosroles.add(usuariorol); }
 * return new ResponseEntity<>(usuariosroles, HttpStatus.OK); } catch (Exception
 * e) { return new ResponseEntity<>(HttpStatus.INTERNALSERVERERROR); }
 * 
 * }
 * 
 * }
 */