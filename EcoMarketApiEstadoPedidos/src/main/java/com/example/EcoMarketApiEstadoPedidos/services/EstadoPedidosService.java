package com.example.EcoMarketApiEstadoPedidos.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiEstadoPedidos.models.entitites.EstadoPedido;
import com.example.EcoMarketApiEstadoPedidos.models.request.ActualizarPedidos;
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

	public EstadoPedido actualizarEstado(ActualizarPedidos request) {
		validarEnvio(request.getIdEnvio());
		validarPedido(request.getPedidoId());

		EstadoPedido estadoPedido = new EstadoPedido();
		estadoPedido.setIdEnvio(request.getIdEnvio());
		estadoPedido.setPedidoId(request.getPedidoId());
		estadoPedido.setEstado(request.getEstado());
		estadoPedido.setActualizadoEn(LocalDateTime.now());

		return estadoPedidosRepository.save(estadoPedido);
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
		try {
			pedidosWebClient.get()
				.uri("/{id_pedido}", pedidoId)
				.retrieve()
				.bodyToMono(Void.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo el webClient pedidos: " + e.getMessage());
		}
	}
}
