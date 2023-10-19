package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.modelo3.Menus;
import com.example.demo.taller1proyecto.modelo3.Procesos;
import com.example.demo.taller1proyecto.modelo3.Usuarios;
import com.example.demo.taller1proyecto.repository.MenusRepository;
import com.example.demo.taller1proyecto.repository.ProcesosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
