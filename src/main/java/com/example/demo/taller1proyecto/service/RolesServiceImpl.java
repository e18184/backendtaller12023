package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.repository.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.taller1proyecto.modelo.Roles;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesRepository rolesRepo;

    @Override
    public void save(Roles roles) {
        rolesRepo.save(roles);
    }

    @Override
    public List<Roles> getRolesList() {
        return rolesRepo.findAll();
    }

    public List<Roles> findByLoginAndPassword(String login, String password) {
        return rolesRepo.findByLoginAndPassword(login, password);
    }

}
