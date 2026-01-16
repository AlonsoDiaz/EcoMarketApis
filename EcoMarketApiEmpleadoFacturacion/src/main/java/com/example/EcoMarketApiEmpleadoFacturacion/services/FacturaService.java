package com.example.EcoMarketApiEmpleadoFacturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketApiEmpleadoFacturacion.controller.GenerarFacturaRequest;
import com.example.EcoMarketApiEmpleadoFacturacion.models.entities.Factura;
import com.example.EcoMarketApiEmpleadoFacturacion.repositories.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    public Factura buscarPorId(int id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public Factura generarFactura(GenerarFacturaRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generarFactura'");
    }
}
