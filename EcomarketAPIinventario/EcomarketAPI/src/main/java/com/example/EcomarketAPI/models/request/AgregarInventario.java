package com.example.EcomarketAPI.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarInventario {
    @NotBlank
    private String nombreProducto;

    @NotBlank
    private int cantidadStock;

    @NotBlank
    private String categoria;
    
    @NotBlank
    private double precio;

    
}
