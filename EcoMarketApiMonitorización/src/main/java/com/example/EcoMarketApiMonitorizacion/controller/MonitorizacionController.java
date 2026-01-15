package com.example.EcoMarketApiMonitorizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiMonitorizacion.models.entities.EstadoSistema;
import com.example.EcoMarketApiMonitorizacion.models.request.AgregarEstadoSistema;
import com.example.EcoMarketApiMonitorizacion.services.MonitorizacionService;

@RequestMapping("monitorizacion")
@RestController
public class MonitorizacionController {

    @Autowired
    private MonitorizacionService monitorizacionService;

    // 🔹 Obtener todos los estados
    @GetMapping("")
    public List<EstadoSistema> obtenerTodos() {
        return monitorizacionService.obtenerTodosLosEstados();
    }

    // 🔹 Obtener estado por ID
    @GetMapping("/{idEstado}")
    public EstadoSistema obtenerPorId(@PathVariable int idEstado) {
        return monitorizacionService.obtenerEstadoPorId(idEstado);
    }

    // 🔹 Registrar nuevo estado del sistema
    @PostMapping("")
    public EstadoSistema registrarEstado(
            @RequestBody AgregarEstadoSistema nuevoEstado) {

        return monitorizacionService.agregarEstado(nuevoEstado);
    }
}
