package com.example.EcoMarketAPItienda.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.EcoMarketAPItienda.models.entities.Tienda;
import com.example.EcoMarketAPItienda.models.request.AgregarTienda;
import com.example.EcoMarketAPItienda.models.request.ActualizarTienda;
import com.example.EcoMarketAPItienda.services.TiendaService;

@RestController
@RequestMapping("tiendas")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;


    @GetMapping
    public List<Tienda> obtenerTodasLasTiendas() {
        return tiendaService.obtenerTodasLasTiendas();
    }

    @GetMapping("/{id}")
    public Tienda obtenerTiendaPorId(@PathVariable int id) {
        return tiendaService.obtenerTiendaPorId(id);
    }


    @PostMapping
    public Tienda agregarTienda(@Valid @RequestBody AgregarTienda nuevaTienda) {
        return tiendaService.agregarTienda(nuevaTienda);
    }

    @PutMapping
    public Tienda actualizarTienda(@Valid @RequestBody ActualizarTienda tiendaDatos) {
        return tiendaService.actualizarTienda(tiendaDatos);
    }

  
    @DeleteMapping("/{id}")
    public String eliminarTienda(@PathVariable int id) {
        return tiendaService.eliminarTienda(id);
    }
}