package com.example.demo.taller1proyecto.service;

<<<<<<< HEAD
import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Procesos;
import com.example.demo.taller1proyecto.modelo3.Usuarios;
import com.example.demo.taller1proyecto.repository.MenusRepository;
=======
>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95
import com.example.demo.taller1proyecto.repository.ProcesosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcesosServiceImpl implements ProcesosService {

    @Autowired
    private MenusRepository menusRepository;
    @Autowired
    private ProcesosRepository procesosRepository;

    @Override
    public List<Procesos> getProcesosForUsuario(Usuarios usuario) {
        List<Menus> menus = new ArrayList<>(menusRepository.findAll());

        List<Procesos> procesos = new ArrayList<>();

        for (Menus menu : menus) {

            procesos.addAll(menu.getCodp());

        }

        return procesos;
    }
}
=======
import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Procesos;

@Service
public class ProcesosServiceImpl implements ProcesosService {
    @Autowired
    ProcesosRepository procesosRepo;

    @Override
    public void save(Procesos procesos) {
        procesosRepo.save(procesos);
    }

    @Override
    public List<Procesos> getProcesosList() {
        return procesosRepo.findAll();
    }
    /*
     * public List<Procesos> findByLoginAndPassword(String login, String password,
     * Long idrol, Long idmenu) { return procesosRepo.findByLoginAndPassword(login,
     * password, idrol, idmenu); }
     */
}
>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95
