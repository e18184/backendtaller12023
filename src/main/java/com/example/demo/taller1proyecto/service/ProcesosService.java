package com.example.demo.taller1proyecto.service;

import java.util.List;
import com.example.demo.taller1proyecto.modelo.Procesos;

public interface ProcesosService {
    void save(Procesos procesos);

    List<Procesos> getProcesosList();

}
