package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.Reclamacion;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request.ReclamacionRequest;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services.ReclamacionService;

@RestController
@RequestMapping("/api/empleado/reclamaciones")
public class ReclamacionController {

    @Autowired
    private ReclamacionService reclamacionService;

    @GetMapping
    public List<Reclamacion> listarReclamaciones() {
        return reclamacionService.listarReclamaciones();
    }

    @GetMapping("/{id}")
    public Reclamacion buscarReclamacion(@PathVariable int id) {
        return reclamacionService.buscarPorId(id);
    }

    @PostMapping
    public Reclamacion registrarReclamacion(
        @RequestBody ReclamacionRequest request) {
    return reclamacionService.registrarReclamacion(request);
    }

}
