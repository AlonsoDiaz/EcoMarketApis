package com.example.EcomarketAPIreportes.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarReportes {
    
    @NotNull
    private Long idReporte;
    @NotBlank
    private String tipo;
    @NotBlank
    private String fecha;
    
}
