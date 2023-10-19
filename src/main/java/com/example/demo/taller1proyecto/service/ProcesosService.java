package com.example.demo.taller1proyecto.service;

import java.util.List;
<<<<<<< HEAD

import com.example.demo.taller1proyecto.modelo3.Procesos;
import com.example.demo.taller1proyecto.modelo3.Usuarios;

public interface ProcesosService {
    List<Procesos> getProcesosForUsuario(Usuarios usuario);
=======
import com.example.demo.taller1proyecto.modelo3.Procesos;

public interface ProcesosService {
    void save(Procesos procesos);

    List<Procesos> getProcesosList();

    // List<Procesos> findByLoginAndPassword(String login, String password, Long
    // idrol, Long idmenu);

>>>>>>> 4a3e207b8326dc9073cfcfd7301879e01d407a95
}
