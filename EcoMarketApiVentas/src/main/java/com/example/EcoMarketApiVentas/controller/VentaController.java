package com.example.EcoMarketApiVentas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiVentas.models.entities.Ventas;
import com.example.EcoMarketApiVentas.models.request.ActualizarVenta;
import com.example.EcoMarketApiVentas.models.request.AgregarVenta;
import com.example.EcoMarketApiVentas.services.VentaService;

@RequestMapping("venta")
@RestController
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("")
    public List<Ventas> obtenerTodasLasVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    @GetMapping("/{idVenta}")
    public Ventas obtenerVentaPorId(@PathVariable int idVenta) {
        return ventaService.obtenerVentaPorId(idVenta);
    }

    @PostMapping("")
    public Ventas registrarVenta(@RequestBody AgregarVenta nuevaVenta) {
        return ventaService.agregarVenta(nuevaVenta);
    }

    @PutMapping("")
    public Ventas actualizarVenta(@RequestBody ActualizarVenta ventaActualizada) {
        return ventaService.actualizarVenta(ventaActualizada);
    }

    @DeleteMapping("/{idVenta}")
    public String eliminarVenta(@PathVariable int idVenta) {
        return ventaService.eliminarVenta(idVenta);
    }
}
