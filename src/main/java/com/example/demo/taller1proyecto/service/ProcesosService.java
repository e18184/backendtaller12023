package com.example.demo.taller1proyecto.service;

import java.util.List;

import com.example.demo.taller1proyecto.modelo3.Procesos;
import com.example.demo.taller1proyecto.modelo3.Usuarios;

public interface ProcesosService {
    List<Procesos> getProcesosForUsuario(Usuarios usuario);
}
