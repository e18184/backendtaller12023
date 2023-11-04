package com.example.demo.taller1proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Procesos;
import com.example.demo.taller1proyecto.service.MenusService;

@RestController
@RequestMapping("/menuscontroller")
public class MenusController {

    @Autowired
    MenusService menuService;

    @GetMapping("/menus")
    public List<Menus> getAllMenus() {
        // Obtener todos los menús y devolverlos como respuesta
        List<Menus> menus = menuService.getAllMenus();
        return menus;
    }

    @GetMapping("/menus/{menuId}")
    public List<Procesos> getProcesosByMenuId(@PathVariable Integer menuId) {
        // Obtener los procesos asociados a un menú por su ID y devolverlos como
        // respuesta
        List<Procesos> procesos = menuService.getProcesosByMenuId(menuId.longValue());
        System.out.println(procesos);
        return procesos;
    }

    // @GetMapping("/{login}/{password}/{idrol}")
    // public ResponseEntity<List<Menus>> findRoles(@PathVariable String login,
    // @PathVariable String password,
    // @PathVariable Integer idrol) {
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
    // return new ResponseEntity<>(HttpStatus.INTERNALSERVERERROR);
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
    // return new ResponseEntity<>(HttpStatus.INTERNALSERVERERROR);
    // }
    // }

    // @PutMapping("/actualizar/{id}")
    // public ResponseEntity<Menus> actualizar(@PathVariable("id") Integer id,
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

    // return new ResponseEntity<>(HttpStatus.INTERNALSERVERERROR);

    // }

    // }

    // @DeleteMapping("/eliminar/{id}")
    // public ResponseEntity<Menus> eliminar(@PathVariable("id") long id) {
    // try {

    // menuService.deleteById(id);
    // return new ResponseEntity<>(HttpStatus.NOCONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNALSERVERERROR);
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

    // return new ResponseEntity<>(HttpStatus.NOCONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNALSERVERERROR);
    // }
    // }

}