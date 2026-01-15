package com.example.EcoMarketAPItienda.services;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketAPItienda.models.entities.Tienda;
import com.example.EcoMarketAPItienda.models.request.ActualizarTienda;
import com.example.EcoMarketAPItienda.models.request.AgregarTienda;
import com.example.EcoMarketAPItienda.repositories.TiendaRepository;

@Service // ¡Importante! Sin esto el Controller no puede inyectarlo
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    public List<Tienda> obtenerTodasLasTiendas() {
        return tiendaRepository.findAll();
    }

    public Tienda obtenerTiendaPorId(int id) {
        return tiendaRepository.findById(id).orElse(null);
    }

    public Tienda agregarTienda(AgregarTienda nuevaTienda) {
        Tienda tienda = new Tienda();
        tienda.setHorarioApertura(nuevaTienda.getHorarioApertura());
        tienda.setPersonalAsignado(nuevaTienda.getPersonalAsignado());
        tienda.setPoliticasLocales(nuevaTienda.getPoliticasLocales());
        return tiendaRepository.save(tienda);
    }

    public Tienda actualizarTienda(ActualizarTienda datos) {
        // Buscamos si existe la tienda
        Tienda tiendaExistente = tiendaRepository.findById(datos.getIdTienda()).orElse(null);
        
        if (tiendaExistente != null) {
            tiendaExistente.setHorarioApertura(datos.getHorarioApertura());
            tiendaExistente.setPersonalAsignado(datos.getPersonalAsignado());
            tiendaExistente.setPoliticasLocales(datos.getPoliticasLocales());
            return tiendaRepository.save(tiendaExistente);
        }
        return null;
    }

    public String eliminarTienda(int id) {
        if (tiendaRepository.existsById(id)) {
            tiendaRepository.deleteById(id);
            return "Tienda eliminada correctamente";
        }
        return "Error: No se encontró la tienda";
    }
}

