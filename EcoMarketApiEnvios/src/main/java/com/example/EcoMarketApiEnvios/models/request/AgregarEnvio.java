package com.example.EcoMarketApiEnvios.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarEnvio {

	@NotBlank
	private String cliente;

	@NotBlank
	private String destino;

	@NotBlank
	private String direccionEntrega;

	@NotNull
	private Integer idTienda;

	@NotNull
	private Integer costo;

	private LocalDate fechaEstimadaEntrega;
}
