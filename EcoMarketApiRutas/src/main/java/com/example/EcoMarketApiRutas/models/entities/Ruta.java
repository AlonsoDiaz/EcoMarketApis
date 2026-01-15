package com.example.EcoMarketApiRutas.models.entities;

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
@Table(name = "rutas")
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRuta;

	@Column(name = "origen", nullable = false)
	private String origen;

	@Column(name = "destino", nullable = false)
	private String destino;

	@Column(name = "distancia_km", nullable = false)
	private int distanciaKm;

	@Column(name = "duracion_min", nullable = false)
	private int duracionMin;

	@Column(name = "costo_estimado", nullable = false)
	private int costoEstimado;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "fecha_creacion", nullable = false)
	private LocalDateTime fechaCreacion;
}
