package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.Devolucion;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request.ReclamacionRequest;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services.DevolucionService;

@RestController
@RequestMapping("/api/empleado/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @GetMapping
    public List<Devolucion> listarDevoluciones() {
        return devolucionService.listarDevoluciones();
    }

    @GetMapping("/{id}")
    public Devolucion buscarDevolucion(@PathVariable int id) {
        return devolucionService.buscarPorId(id);
    }

    @PostMapping
    public Devolucion registrarDevolucion(
        @RequestBody ReclamacionRequest request) {
    return devolucionService.registrarDevolucion(request);
    }

}
