package com.example.EcoMarketApiEstadoPedidos.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiEstadoPedidos.models.entitites.EstadoPedido;
import com.example.EcoMarketApiEstadoPedidos.models.dto.PedidoDto;
import com.example.EcoMarketApiEstadoPedidos.models.request.ActualizarEstadoPedido;
import com.example.EcoMarketApiEstadoPedidos.models.request.CrearEstadoPedido;
import com.example.EcoMarketApiEstadoPedidos.repositories.EstadoPedidosRepository;

@Service
public class EstadoPedidosService {
	@Autowired
	private EstadoPedidosRepository estadoPedidosRepository;

	@Autowired
	@Qualifier("enviosWebClient")
	private WebClient enviosWebClient;

	@Autowired
	@Qualifier("pedidosWebClient")
	private WebClient pedidosWebClient;

	public List<EstadoPedido> obtenerTodosLosEstados() {
		return estadoPedidosRepository.findAll();
	}

	public EstadoPedido obtenerEstadoPorId(int id) {
		return estadoPedidosRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado de pedido no encontrado"));
	}

	public EstadoPedido agregarEstado(CrearEstadoPedido request) {
		validarEnvio(request.getIdEnvio());
		validarPedido(request.getPedidoId());

		EstadoPedido estadoPedido = new EstadoPedido();
		estadoPedido.setIdEnvio(request.getIdEnvio());
		estadoPedido.setPedidoId(request.getPedidoId());
		estadoPedido.setEstado(request.getEstado());
		estadoPedido.setActualizadoEn(LocalDateTime.now());

		return estadoPedidosRepository.save(estadoPedido);
	}

	public EstadoPedido actualizarEstado(ActualizarEstadoPedido request) {
		EstadoPedido existente = obtenerEstadoPorId(request.getId());

		validarEnvio(request.getIdEnvio());
		validarPedido(request.getPedidoId());

		existente.setIdEnvio(request.getIdEnvio());
		existente.setPedidoId(request.getPedidoId());
		existente.setEstado(request.getEstado());
		existente.setActualizadoEn(LocalDateTime.now());

		return estadoPedidosRepository.save(existente);
	}

	public String eliminarEstado(int id) {
		EstadoPedido existente = obtenerEstadoPorId(id);
		estadoPedidosRepository.delete(existente);
		return "Estado eliminado";
	}

	private void validarEnvio(int idEnvio) {
		try {
			enviosWebClient.get()
				.uri("/{id}", idEnvio)
				.retrieve()
				.bodyToMono(Void.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo el webClient envios: " + e.getMessage());
		}
	}

	private void validarPedido(int pedidoId) {
		PedidoDto pedido;
		try {
			pedido = pedidosWebClient.get()
				.uri("/{id_pedido}", pedidoId)
				.retrieve()
				.bodyToMono(PedidoDto.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo el webClient pedidos: " + e.getMessage());
		}

		if (pedido == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado.");
		}
	}
}
