package com.example.EcoMarketApiMonitorizacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiMonitorizacion.models.entities.EstadoSistema;
import com.example.EcoMarketApiMonitorizacion.models.request.AgregarEstadoSistema;
import com.example.EcoMarketApiMonitorizacion.repositories.EstadoSistemaRepository;

@Service
public class MonitorizacionService {

    @Autowired
    private EstadoSistemaRepository estadoSistemaRepository;

    
    public List<EstadoSistema> obtenerTodosLosEstados() {
        return estadoSistemaRepository.findAll();
    }

    
    public EstadoSistema obtenerEstadoPorId(int idEstado) {
        EstadoSistema estado = estadoSistemaRepository.findById(idEstado).orElse(null);

        if (estado == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Estado del sistema no encontrado."
            );
        }

        return estado;
    }

    
    public EstadoSistema agregarEstado(AgregarEstadoSistema nuevo) {
        EstadoSistema estado = new EstadoSistema();

        estado.setEstado(nuevo.getEstado());
        estado.setUsoCpu(nuevo.getUsoCpu());
        estado.setUsoMemoria(nuevo.getUsoMemoria());
        estado.setMensaje(nuevo.getMensaje());

        return estadoSistemaRepository.save(estado);
    }
}
