package com.example.EcoMarketApiVentas.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;

    @Column(name = "cliente", nullable = false)
    private String cliente;

    @Column(name = "subtotal", nullable = false)
    private Integer subtotal;

    @Column(name = "descuento_porcentaje")
    private Integer descuentoPorcentaje;

    @Column(name = "oferta_porcentaje")
    private Integer ofertaPorcentaje;

    @Column(name = "total", nullable = false)
    private Integer total;
}
