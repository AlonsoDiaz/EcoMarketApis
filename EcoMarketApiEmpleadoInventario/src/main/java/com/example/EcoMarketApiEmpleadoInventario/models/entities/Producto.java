package com.example.EcoMarketApiEmpleadoInventario.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int stock_actual;

    @Column(nullable = false)
    private double precio_unitario;

    @Column(nullable = false)
    private String categoria;
}