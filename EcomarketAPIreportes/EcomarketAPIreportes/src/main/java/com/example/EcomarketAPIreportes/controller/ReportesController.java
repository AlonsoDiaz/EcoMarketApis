package com.example.EcomarketAPIreportes.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.EcomarketAPIreportes.Services.ReportesService;
import com.example.EcomarketAPIreportes.models.entities.Reportes;
import com.example.EcomarketAPIreportes.models.request.ActualizarReportes;
import com.example.EcomarketAPIreportes.models.request.AgregarReportes;

@RestController
@RequestMapping("reportes")
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

    @GetMapping
    public List<Reportes> listar() {
        return reportesService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Reportes ver(@PathVariable int id) {
        return reportesService.obtenerPorId(id);
    }

    @PostMapping
    public Reportes guardar(@RequestBody AgregarReportes request) {
        return reportesService.crearReporte(request);
    }

    @PutMapping("/{id}")
    public Reportes editar(@PathVariable int id, @RequestBody ActualizarReportes request) {
        request.setIdReporte((long) id);
        return reportesService.actualizarReporte(request);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return reportesService.eliminarReporte(id);
    }
}