package com.example.EcoMarketApiVentas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiVentas.models.entities.Ventas;
import com.example.EcoMarketApiVentas.models.request.ActualizarVenta;
import com.example.EcoMarketApiVentas.models.request.AgregarVenta;
import com.example.EcoMarketApiVentas.repositories.VentasRepository;

@Service
public class VentaService {

    @Autowired
    private VentasRepository ventasRepository;

    public List<Ventas> obtenerTodasLasVentas() {
        return ventasRepository.findAll();
    }

    public Ventas obtenerVentaPorId(int idVenta) {
        return ventasRepository.findById(idVenta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada."));
    }

    public Ventas agregarVenta(AgregarVenta nueva) {
        Ventas venta = new Ventas();
        venta.setCliente(nueva.getCliente());
        venta.setSubtotal(validarSubtotal(nueva.getSubtotal()));

        venta.setDescuentoPorcentaje(validarPorcentaje(nueva.getDescuentoPorcentaje()));
        venta.setOfertaPorcentaje(validarPorcentaje(nueva.getOfertaPorcentaje()));
        venta.setTotal(venta.getSubtotal());

        return ventasRepository.save(venta);
    }

    public Ventas actualizarVenta(ActualizarVenta nueva) {
        Ventas venta = ventasRepository.findById(nueva.getId_venta())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada."));

        venta.setCliente(nueva.getCliente());
        venta.setSubtotal(validarSubtotal(nueva.getSubtotal()));

        venta.setDescuentoPorcentaje(validarPorcentaje(nueva.getDescuentoPorcentaje()));
        venta.setOfertaPorcentaje(validarPorcentaje(nueva.getOfertaPorcentaje()));
        venta.setTotal(venta.getSubtotal());

        return ventasRepository.save(venta);
    }

    public String eliminarVenta(int idVenta) {
        if (ventasRepository.existsById(idVenta)) {
            ventasRepository.deleteById(idVenta);
            return "Venta eliminada correctamente.";
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada.");
    }

    private int validarPorcentaje(Integer valor) {
        if (valor == null) {
            return 0;
        }
        if (valor < 0 || valor > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Los porcentajes deben estar entre 0 y 100.");
        }
        return valor;
    }

    private int validarSubtotal(Integer subtotal) {
        if (subtotal == null || subtotal < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El subtotal debe ser mayor o igual a 0.");
        }
        return subtotal;
    }
}
