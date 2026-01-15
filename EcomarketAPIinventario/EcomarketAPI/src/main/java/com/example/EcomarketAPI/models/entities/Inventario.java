package com.example.EcomarketAPI.models.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "cantidad_stock", nullable = false)
    private int cantidadStock;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "precio")
    private double precio;
}