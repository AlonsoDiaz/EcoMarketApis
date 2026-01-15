package com.example.EcoMarketApiEnvios.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiEnvios.models.dto.TiendaDto;
import com.example.EcoMarketApiEnvios.models.entities.Envio;
import com.example.EcoMarketApiEnvios.models.request.ActualizarEnvio;
import com.example.EcoMarketApiEnvios.models.request.AgregarEnvio;
import com.example.EcoMarketApiEnvios.repositories.EnvioRepository;

@Service
public class EnvioService {

	@Autowired
	private EnvioRepository envioRepository;

	@Autowired
	private WebClient tiendaWebClient;

	public List<Envio> obtenerTodos() {
		return envioRepository.findAll();
	}

	public Envio obtenerEnvioPorId(int idEnvio) {
		Envio envio = envioRepository.findById(idEnvio).orElse(null);
		if (envio == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Envio no encontrado.");
		}
		return envio;
	}

	public Envio agregarEnvio(AgregarEnvio nuevo) {
		TiendaDto tienda = null;
		try {
			tienda = tiendaWebClient.get()
				.uri("/{idTienda}", nuevo.getIdTienda())
				.retrieve()
				.bodyToMono(TiendaDto.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo el webClient: " + e.getMessage());
		}

		if (tienda == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tienda no encontrada.");
		}

		Envio envio = new Envio();
		envio.setCliente(nuevo.getCliente());
		envio.setDestino(nuevo.getDestino());
		envio.setDireccionEntrega(nuevo.getDireccionEntrega());
		envio.setIdTienda(nuevo.getIdTienda());
		envio.setCosto(nuevo.getCosto());
		envio.setFechaEstimadaEntrega(nuevo.getFechaEstimadaEntrega());
		envio.setFechaEnvio(LocalDateTime.now());
		envio.setEstado("PENDIENTE");
		return envioRepository.save(envio);
	}

	public Envio actualizarEnvio(ActualizarEnvio nuevo) {
    Envio envio = envioRepository.findById(nuevo.getIdEnvio()).orElse(null);
    if (envio == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Envio no encontrado.");
    }

    envio.setEstado(nuevo.getEstado());
    envio.setDestino(nuevo.getDestino());
    envio.setDireccionEntrega(nuevo.getDireccionEntrega());
    envio.setIdTienda(nuevo.getIdTienda());
    envio.setCosto(nuevo.getCosto());
    envio.setFechaEstimadaEntrega(nuevo.getFechaEstimadaEntrega());

    return envioRepository.save(envio);
}

	public String eliminarEnvio(int idEnvio) {
		if (envioRepository.existsById(idEnvio)) {
			envioRepository.deleteById(idEnvio);
			return "Envio eliminado correctamente.";
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Envio no encontrado.");
		}
	}
}
