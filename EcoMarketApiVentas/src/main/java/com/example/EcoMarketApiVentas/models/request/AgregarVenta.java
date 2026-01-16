package com.example.EcoMarketApiVentas.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class AgregarVenta {

    @NotBlank
    private String cliente;

   
    private Integer subtotal;

    
    private Integer descuentoPorcentaje = 0;

    
    private Integer ofertaPorcentaje = 0;
}
