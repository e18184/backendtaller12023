package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.repository.MenusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.taller1proyecto.modelo.Menus;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    MenusRepository menusRepo;

    @Override
    public void save(Menus menus) {
        menusRepo.save(menus);
    }

    @Override
    public List<Menus> getMenusList() {
        return menusRepo.findAll();
    }

    @Override
    public List<Menus> findByLoginAndPassword(String login, String password, Long idrol) {
        return menusRepo.findByLoginAndPassword(login, password, idrol);
    }

}
