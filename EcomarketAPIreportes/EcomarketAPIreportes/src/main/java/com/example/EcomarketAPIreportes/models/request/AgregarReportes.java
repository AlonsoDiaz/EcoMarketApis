package com.example.EcomarketAPIreportes.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarReportes {
    @NotBlank
    private String tipo;
    @NotBlank
    private String fecha;
    
}
