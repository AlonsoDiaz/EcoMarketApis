package com.example.EcoMarketApiEmpleadoFacturacion.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_factura;

    @Column(nullable = false)
    private int id_venta;

    @Column(nullable = false)
    private LocalDate fecha_emision;

    @Column(nullable = false)
    private double total_facturado;

    @Column(nullable = false)
    private String correo_cliente;

}
