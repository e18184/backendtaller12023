package com.example.demo.taller1proyecto.service;

import com.example.demo.taller1proyecto.repository.ProcesosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.taller1proyecto.modelo.Procesos;

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
}