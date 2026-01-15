package com.example.EcoMarketApiRutas.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiRutas.models.entities.Ruta;
import com.example.EcoMarketApiRutas.models.request.ActualizarRuta;
import com.example.EcoMarketApiRutas.models.request.AgregarRuta;
import com.example.EcoMarketApiRutas.repositories.RutaReposity;

@Service
public class RutaService {

	@Autowired
	private RutaReposity rutaReposity;

	public List<Ruta> obtenerTodas() {
		return rutaReposity.findAll();
	}

	public Ruta obtenerPorId(int idRuta) {
		Ruta ruta = rutaReposity.findById(idRuta).orElse(null);
		if (ruta == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruta no encontrada.");
		}
		return ruta;
	}

	public Ruta agregarRuta(AgregarRuta nueva) {
		Ruta ruta = new Ruta();
		ruta.setOrigen(nueva.getOrigen());
		ruta.setDestino(nueva.getDestino());
		ruta.setDistanciaKm(nueva.getDistanciaKm());
		ruta.setDuracionMin(nueva.getDuracionMin());
		ruta.setCostoEstimado(nueva.getCostoEstimado());
		ruta.setEstado("ACTIVA");
		ruta.setFechaCreacion(LocalDateTime.now());
		return rutaReposity.save(ruta);
	}

	public Ruta actualizarRuta(ActualizarRuta cambios) {
		Ruta ruta = rutaReposity.findById(cambios.getIdRuta()).orElse(null);
		if (ruta == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruta no encontrada.");
		}

		ruta.setOrigen(cambios.getOrigen());
		ruta.setDestino(cambios.getDestino());
		ruta.setDistanciaKm(cambios.getDistanciaKm());
		ruta.setDuracionMin(cambios.getDuracionMin());
		ruta.setCostoEstimado(cambios.getCostoEstimado());
		ruta.setEstado(cambios.getEstado());

		return rutaReposity.save(ruta);
	}

	public String eliminarRuta(int idRuta) {
		if (rutaReposity.existsById(idRuta)) {
			rutaReposity.deleteById(idRuta);
			return "Ruta eliminada correctamente.";
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruta no encontrada.");
		}
	}
}
