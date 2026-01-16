package com.example.EcoMarketApiEstadoPedidos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarPedidos {

	@NotBlank
	private int pedidoId;

	@NotBlank
	private int idEnvio;

	@NotBlank
	private String estado;
}
