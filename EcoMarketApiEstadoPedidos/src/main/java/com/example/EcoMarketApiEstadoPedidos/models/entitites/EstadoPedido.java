package com.example.EcoMarketApiEstadoPedidos.models.entitites;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "estado_pedidos")
public class EstadoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "id_pedido", nullable = false)
	private int pedidoId;

	@Column(name = "idEnvio", nullable = false)
	private int idEnvio;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "actualizado_en", nullable = false)
	private LocalDateTime actualizadoEn;
}
