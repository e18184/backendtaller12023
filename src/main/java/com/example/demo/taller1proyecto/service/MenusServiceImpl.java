package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Procesos;
import com.example.demo.taller1proyecto.repository.MenusRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    MenusRepository menusRepo;

    public List<Procesos> getProcesosByMenuId(Integer menuId) {
        return menusRepo.getProcesosByMenuId(menuId);
    }

    public List<Menus> getAllMenus() {
        return menusRepo.findAll();
    }

    // @Override
    // public void save(Menus menus) {
    // menusRepo.save(menus);
    // }

    // @Override
    // public List<Menus> getMenusList() {
    // return menusRepo.findAll();
    // }

    // @Override
    // public List<Menus> findByLoginAndPassword(String login, String password,
    // Integer
    // idrol) {
    // return menusRepo.findByLoginAndPassword(login, password, idrol);
    // }

    // public Optional<Menus> findById(Integer id) {
    // return menusRepo.findById(id);
    // }

    // public void deleteById(Integer id) {
    // menusRepo.deleteById(id);
    // }

}
