package com.example.EcomarketAPI.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarInventario {
    @NotNull
    private Long idProducto;

    @NotBlank
    private String nombreProducto;

    @NotBlank
    private int cantidadStock;

    @NotBlank
    private String categoria;
    
    @NotBlank
    private double precio;

    
}
