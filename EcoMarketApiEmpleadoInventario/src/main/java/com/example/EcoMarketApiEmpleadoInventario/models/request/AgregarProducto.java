package com.example.EcoMarketApiEmpleadoInventario.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarProducto {
    
    @NotBlank
    private String nombre;

    @NotBlank
    private double precio_unitario;

    @NotBlank
    private int stock_actual;
}

