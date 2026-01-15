package com.example.EcoMarketApiProveedores.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "proveedores")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "contacto", nullable = false)
	private String contacto;

	@Column(name = "telefono", nullable = false)
	private String telefono;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	
	
	@Column(name = "minimo_pedido", nullable = false)
	private int minimoPedido;

	
	@Column(name = "condiciones", nullable = false)
	private String condiciones;

	@Column(name = "notas_recepcion")
	private String notasRecepcion;

	@Column(name = "activo", nullable = false)
	private boolean activo = true;
}
