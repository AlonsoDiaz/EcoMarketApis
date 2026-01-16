package com.example.EcoMarketApiEnvios.models.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "envios")
public class Envio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEnvio;

	@Column(name = "cliente", nullable = false)
	private String cliente;

	@Column(name = "destino", nullable = false)
	private String destino;

	@Column(name = "direccion_entrega", nullable = false)
	private String direccionEntrega;

	@Column(name = "id_tienda", nullable = false)
	private int idTienda;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "costo", nullable = false)
	private int costo;

	@Column(name = "fecha_envio", nullable = false)
	private LocalDateTime fechaEnvio;

	@Column(name = "fecha_estimada_entrega")
	private LocalDate fechaEstimadaEntrega;
}
