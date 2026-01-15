package com.example.EcoMarketApiEstadoPedidos.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiEstadoPedidos.models.dto.EnvioDto;
import com.example.EcoMarketApiEstadoPedidos.models.dto.PedidoDto;
import com.example.EcoMarketApiEstadoPedidos.models.entitites.EstadoPedido;
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
		EstadoPedido estado = estadoPedidosRepository.findById(id).orElse(null);
		if (estado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado de pedido no encontrado.");
		}
		return estado;
	}

	public EstadoPedido agregarEstado(CrearEstadoPedido nuevo) {
		EnvioDto envio = null;
		PedidoDto pedido = null;
		try {
			envio = enviosWebClient.get()
				.uri("/{idEnvio}", nuevo.getIdEnvio())
				.retrieve()
				.bodyToMono(EnvioDto.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo el webClient envios: " + e.getMessage());
		}

		try {
			pedido = pedidosWebClient.get()
				.uri("/{id_pedido}", nuevo.getPedidoId())
				.retrieve()
				.bodyToMono(PedidoDto.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo el webClient pedidos: " + e.getMessage());
		}

		if (envio == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Envio no encontrado.");
		}
		if (pedido == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado.");
		}

		EstadoPedido estadoPedido = new EstadoPedido();
		estadoPedido.setIdEnvio(nuevo.getIdEnvio());
		estadoPedido.setPedidoId(nuevo.getPedidoId());
		estadoPedido.setEstado(nuevo.getEstado());
		estadoPedido.setActualizadoEn(LocalDateTime.now());
		return estadoPedidosRepository.save(estadoPedido);
	}

	public EstadoPedido actualizarEstado(ActualizarEstadoPedido nuevo) {
		EstadoPedido estado = estadoPedidosRepository.findById(nuevo.getId()).orElse(null);
		if (estado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado de pedido no encontrado.");
		}

		EnvioDto envio = null;
		PedidoDto pedido = null;
		try {
			envio = enviosWebClient.get()
				.uri("/{idEnvio}", nuevo.getIdEnvio())
				.retrieve()
				.bodyToMono(EnvioDto.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo el webClient envios: " + e.getMessage());
		}

		try {
			pedido = pedidosWebClient.get()
				.uri("/{id_pedido}", nuevo.getPedidoId())
				.retrieve()
				.bodyToMono(PedidoDto.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo el webClient pedidos: " + e.getMessage());
		}

		if (envio == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Envio no encontrado.");
		}
		if (pedido == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado.");
		}

		estado.setIdEnvio(nuevo.getIdEnvio());
		estado.setPedidoId(nuevo.getPedidoId());
		estado.setEstado(nuevo.getEstado());
		estado.setActualizadoEn(LocalDateTime.now());
		return estadoPedidosRepository.save(estado);
	}

	public String eliminarEstado(int id) {
		if (estadoPedidosRepository.existsById(id)) {
			estadoPedidosRepository.deleteById(id);
			return "Estado eliminado.";
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado de pedido no encontrado.");
		}
	}


	
}
