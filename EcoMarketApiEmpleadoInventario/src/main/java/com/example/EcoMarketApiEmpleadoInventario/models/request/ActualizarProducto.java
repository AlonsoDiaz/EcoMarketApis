package com.example.EcoMarketApiEmpleadoInventario.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarProducto {

    @NotBlank
    private int id_producto;

    @NotBlank
    private String nombre;

    @NotBlank
    private double precio_unitario;

    @NotBlank
    private int stock_actual;
}