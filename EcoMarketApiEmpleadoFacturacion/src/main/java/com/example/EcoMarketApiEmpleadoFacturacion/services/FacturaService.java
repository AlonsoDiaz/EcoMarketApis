package com.example.EcoMarketApiEmpleadoFacturacion.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.EcoMarketApiEmpleadoFacturacion.models.entities.Factura;
import com.example.EcoMarketApiEmpleadoFacturacion.repositories.FacturaRepository;

@Service
public class FacturaService {
    private final FacturaRepository repository;

    public FacturaService(FacturaRepository repository) {
        this.repository = repository;
    }

    public List<Factura> listar() {
        return repository.findAll();
    }

    public Factura guardar(Factura factura) {
        if (factura.getFecha_emision() == null) {
            factura.setFecha_emision(LocalDate.now());
        }
        return repository.save(factura);
    }

    public Factura actualizar(int id, Factura datos) {
        return repository.findById(id).map(ex -> {
            ex.setId_venta(datos.getId_venta());
            ex.setTotal_facturado(datos.getTotal_facturado());
            ex.setCorreo_cliente(datos.getCorreo_cliente());
            return repository.save(ex);
        }).orElse(null);
    }

    public boolean eliminar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}