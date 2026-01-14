package com.example.EcomarketAPIgerente.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcomarketAPIgerente.models.entities.Gerente;
import com.example.EcomarketAPIgerente.models.request.ActualizarMarca;
import com.example.EcomarketAPIgerente.models.request.AgregarMarca;
import com.example.EcomarketAPIgerente.repositories.GerenteRepository;


@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    public List<Gerente> obtenerTodosLosGerentes() {
        return gerenteRepository.findAll();
    }

    public Gerente obtenerGerentePorId(int id) {
        return gerenteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gerente no encontrado"));
    }

    public Gerente agregarGerente(AgregarMarca nueva) {
        Gerente gerenteNuevo = new Gerente();
        gerenteNuevo.setNombre(nueva.getNombre());
        gerenteNuevo.setTienda("Pendiente"); 
        return gerenteRepository.save(gerenteNuevo);
    }

    public String eliminarGerente(int id) {
        if (!gerenteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gerente no encontrado");
        }
        gerenteRepository.deleteById(id);
        return "Gerente eliminado correctamente";
    }

    public Gerente actualizarGerente(ActualizarMarca datos) {
        return gerenteRepository.findById(datos.getId())
            .map(gerenteExistente -> {
                gerenteExistente.setNombre(datos.getNombre());
                return gerenteRepository.save(gerenteExistente);
            })
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gerente no encontrado"));
    }
}