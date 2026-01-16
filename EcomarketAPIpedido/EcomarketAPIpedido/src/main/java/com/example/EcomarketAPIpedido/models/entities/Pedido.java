package com.example.EcomarketAPIpedido.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int id_pedido;

    @Column(name = "cliente", nullable = false)
    private String cliente;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "tienda", nullable = false)
    private String tienda;
}
