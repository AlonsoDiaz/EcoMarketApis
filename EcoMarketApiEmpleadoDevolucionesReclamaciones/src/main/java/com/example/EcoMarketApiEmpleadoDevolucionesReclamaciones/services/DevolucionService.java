package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.Devolucion;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request.ReclamacionRequest;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.repositories.DevolucionRepository;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    public List<Devolucion> listarDevoluciones() {
        return devolucionRepository.findAll();
    }

    public Devolucion buscarPorId(int id) {
        return devolucionRepository.findById(id).orElse(null);
    }

    public Devolucion registrarDevolucion(ReclamacionRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarDevolucion'");
    }
}
