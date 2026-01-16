package com.example.EcoMarketApiEmpleadoFacturacion.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketApiEmpleadoFacturacion.models.entities.Factura;
import com.example.EcoMarketApiEmpleadoFacturacion.models.request.GenerarFacturaRequest;
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
        Factura factura = new Factura();
        factura.setId_venta(request.getId_venta());
        factura.setTotal_facturado(request.getTotal_facturado());
        factura.setCorreo_cliente(request.getCorreo_cliente());
        factura.setFecha_emision(LocalDate.now());
        return facturaRepository.save(factura);
    }
}
