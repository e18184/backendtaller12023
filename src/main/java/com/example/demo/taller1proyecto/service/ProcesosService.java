package com.example.demo.taller1proyecto.service;

import java.util.List;
import com.example.demo.taller1proyecto.modelo3.Procesos;

public interface ProcesosService {
    void save(Procesos procesos);

    List<Procesos> getProcesosList();

    // List<Procesos> findByLoginAndPassword(String login, String password, Long
    // idrol, Long idmenu);

}
