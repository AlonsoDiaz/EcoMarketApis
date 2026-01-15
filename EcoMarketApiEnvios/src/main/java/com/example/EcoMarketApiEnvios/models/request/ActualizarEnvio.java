package com.example.EcoMarketApiEnvios.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarEnvio {

	@NotNull
	private Integer idEnvio;

	private String estado;

	private String destino;

	private String direccionEntrega;

	private Integer idTienda;

	private Double costo;

	private LocalDate fechaEstimadaEntrega;
}
