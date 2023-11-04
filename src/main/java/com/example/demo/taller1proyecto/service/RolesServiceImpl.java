package com.example.demo.taller1proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesRepository rolesRepo;

    public List<Menus> getMenusByRoles(Integer roleId) {
        return rolesRepo.getMenusByRoles(roleId);
    }

    // @Override
    // public void save(Roles roles) {
    // rolesRepo.save(roles);
    // }

    // @Override
    // public List<Roles> getRolesList() {
    // return rolesRepo.findAll();
    // }

    // // public List<Roles> findByLoginAndPassword(String login, String password) {
    // // return rolesRepo.findByLoginAndPassword(login, password);
    // // }

    // public Optional<Roles> findById(Integer id) {
    // return rolesRepo.findById(id);
    // }

    // public void deleteById(Integer id) {
    // rolesRepo.deleteById(id);
    // }

    // @Override
    // public List<Roles> findByUsuarios(Usuarios usuarios) {
    // return rolesRepo.findByUsuarioAndContrasena(usuarios.getUsuario(),
    // usuarios.getContrasena());
    // }

}
