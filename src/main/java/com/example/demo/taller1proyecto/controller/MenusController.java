package com.example.demo.taller1proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.taller1proyecto.service.MenusService;

@RestController
@RequestMapping("/menuscontroller")
public class MenusController {

    @Autowired
    MenusService menuService;

    // @GetMapping("/{login}/{password}/{idrol}")
    // public ResponseEntity<List<Menus>> findRoles(@PathVariable String login,
    // @PathVariable String password,
    // @PathVariable Long idrol) {
    // try {

    // List<Menus> usuarios = menuService.findByLoginAndPassword(login, password,
    // idrol);
    // List<Menus> usuariosmenus = new ArrayList<>();

    // // Iterar sobre la lista de usuarios y establecer las relaciones a null
    // for (Menus menus : usuarios) {
    // Menus usuariomenus = new Menus();
    // usuariomenus.setNombre(menus.getNombre());
    // usuariosmenus.add(usuariomenus);
    // }
    // return new ResponseEntity<>(usuariosmenus, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @PostMapping("/guardar")
    // public ResponseEntity<Menus> create(@RequestBody Menus menus) {
    // try {
    // Menus menu = new Menus();
    // menu.setNombre(menus.getNombre());
    // menu.setEstado(menus.getEstado());

    // menuService.save(menu);

    // return new ResponseEntity<>(menu, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @PutMapping("/actualizar/{id}")
    // public ResponseEntity<Menus> actualizar(@PathVariable("id") Long id,
    // @RequestBody Menus menus) {
    // try {
    // Menus menu = menuService.findById(id).get();

    // if (Objects.nonNull(menu)) {

    // menu.setNombre(menus.getNombre());
    // menu.setEstado(menus.getEstado());
    // menuService.save(menu);

    // }
    // return new ResponseEntity<Menus>(menu, HttpStatus.OK);
    // } catch (Exception e) {

    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    // }

    // }

    // @DeleteMapping("/eliminar/{id}")
    // public ResponseEntity<Menus> eliminar(@PathVariable("id") long id) {
    // try {

    // menuService.deleteById(id);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @DeleteMapping("/baja/{id}")
    // public ResponseEntity<Menus> baja(@PathVariable("id") long id) {
    // try {

    // Menus menu = menuService.findById(id).get();
    // if (Objects.nonNull(menu)) {

    // menu.setEstado(0);
    // menuService.save(menu);

    // }

    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}
