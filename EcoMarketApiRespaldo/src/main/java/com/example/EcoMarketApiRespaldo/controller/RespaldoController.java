package com.example.EcoMarketApiRespaldo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.EcoMarketApiRespaldo.models.entities.Respaldo;
import com.example.EcoMarketApiRespaldo.models.request.CrearRespaldoRequest;
import com.example.EcoMarketApiRespaldo.models.request.RestaurarRespaldoRequest;
import com.example.EcoMarketApiRespaldo.services.RespaldoService;


@RestController
@RequestMapping("respaldos")
public class RespaldoController {

    @Autowired
    private RespaldoService respaldoService;

    
    @GetMapping("")
    public List<Respaldo> obtenerTodos() {
        return respaldoService.obtenerTodosLosRespaldos();
    }

    
    @GetMapping("/{idRespaldo}")
    public Respaldo obtenerPorId(@PathVariable int idRespaldo) {
        return respaldoService.obtenerRespaldoPorId(idRespaldo);
    }

    
    @PostMapping("")
    public Respaldo crearRespaldo(@RequestBody CrearRespaldoRequest request) {
        return respaldoService.crearRespaldo(request);
    }

    
    @PostMapping("/restaurar")
    public String restaurar(@RequestBody RestaurarRespaldoRequest request) {
        return respaldoService.restaurarRespaldo(request);
    }
}
