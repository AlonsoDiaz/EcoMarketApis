package com.example.EcomarketAPI.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AgregarInventario {
    @NotBlank
    private String nombreProducto;

    @NotNull
    @Positive
    private int cantidadStock;

    @NotBlank
    private String categoria;
    
    @NotNull
    @Positive
    private double precio;

    
}
