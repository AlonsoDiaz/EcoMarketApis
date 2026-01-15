package com.example.EcoMarketApiRespaldo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiRespaldo.models.entities.Respaldo;
import com.example.EcoMarketApiRespaldo.models.request.CrearRespaldoRequest;
import com.example.EcoMarketApiRespaldo.models.request.RestaurarRespaldoRequest;
import com.example.EcoMarketApiRespaldo.repositories.RespaldoRepository;



@Service
public class RespaldoService {

    @Autowired
    private RespaldoRepository respaldoRepository;

    
    public List<Respaldo> obtenerTodosLosRespaldos() {
        return respaldoRepository.findAll();
    }

    
    public Respaldo obtenerRespaldoPorId(int idRespaldo) {
    Respaldo respaldo = respaldoRepository.findById(idRespaldo).orElse(null);

        if (respaldo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Respaldo no encontrado.");
        }

            return respaldo;
    }

    
    public Respaldo crearRespaldo(CrearRespaldoRequest request) {
        Respaldo respaldo = new Respaldo();
        respaldo.setTipo(request.getTipo());
        respaldo.setDescripcion(request.getDescripcion());
        respaldo.setFechaRespaldo(LocalDateTime.now());
        respaldo.setEstado("COMPLETADO");

        return respaldoRepository.save(respaldo);
    }

    
    public String restaurarRespaldo(RestaurarRespaldoRequest request) {
        Respaldo respaldo = respaldoRepository.findById(request.getIdRespaldo()).orElse(null);

        if (respaldo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Respaldo no encontrado.");
        }

        
        return "Datos restaurados correctamente desde el respaldo ID: " + respaldo.getIdRespaldo();
    }
}
