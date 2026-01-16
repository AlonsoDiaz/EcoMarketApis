package com.example.EcoMarketApiEmpleadoFacturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiEmpleadoFacturacion.models.entities.Factura;
import com.example.EcoMarketApiEmpleadoFacturacion.models.request.GenerarFacturaRequest;
import com.example.EcoMarketApiEmpleadoFacturacion.services.FacturaService;

@RestController
@RequestMapping("/api/empleado/facturacion")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public Factura buscarFactura(@PathVariable int id) {
        return facturaService.buscarPorId(id);
    }

    @PostMapping
    public Factura generarFactura(@RequestBody GenerarFacturaRequest request) {
        return facturaService.generarFactura(request);
    }
}
