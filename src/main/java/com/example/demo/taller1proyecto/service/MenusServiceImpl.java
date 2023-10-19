package com.example.demo.taller1proyecto.service;

<<<<<<< HEAD
import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Roles;
import com.example.demo.taller1proyecto.modelo3.Usuarios;
import com.example.demo.taller1proyecto.repository.MenusRepository;
import com.example.demo.taller1proyecto.repository.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private MenusRepository menusRepository;

    @Override
    public List<Menus> getMenusForUsuario(Usuarios usuario) {
        List<Roles> roles = new ArrayList<>(usuario.getId_rol());
        List<Menus> menus = new ArrayList<>();

        for (Roles rol : roles) {
            menus.addAll(rol.getCodm());
        }

        return menus;
    }
=======
import com.example.demo.taller1proyecto.repository.MenusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.taller1proyecto.modelo3.Menus;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    MenusRepository menusRepo;

    // @Override
    // public void save(Menus menus) {
    // menusRepo.save(menus);
    // }

    // @Override
    // public List<Menus> getMenusList() {
    // return menusRepo.findAll();
    // }

    // @Override
    // public List<Menus> findByLoginAndPassword(String login, String password, Long
    // idrol) {
    // return menusRepo.findByLoginAndPassword(login, password, idrol);
    // }

    // public Optional<Menus> findById(Long id) {
    // return menusRepo.findById(id);
    // }

    // public void deleteById(Long id) {
    // menusRepo.deleteById(id);
    // }
>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95

}
