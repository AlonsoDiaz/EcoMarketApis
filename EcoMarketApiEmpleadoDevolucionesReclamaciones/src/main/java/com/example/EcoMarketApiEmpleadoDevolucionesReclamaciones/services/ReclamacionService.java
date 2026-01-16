package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.Reclamacion;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request.ReclamacionRequest;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.repositories.ReclamacionRepository;

@Service
public class ReclamacionService {

    @Autowired
    private ReclamacionRepository reclamacionRepository;

    public List<Reclamacion> listarReclamaciones() {
        return reclamacionRepository.findAll();
    }

    public Reclamacion buscarPorId(int id) {
        return reclamacionRepository.findById(id).orElse(null);
    }

    public Reclamacion registrarReclamacion(ReclamacionRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarReclamacion'");
    }
}
