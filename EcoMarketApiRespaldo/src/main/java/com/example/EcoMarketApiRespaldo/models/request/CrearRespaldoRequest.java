package com.example.EcoMarketApiRespaldo.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CrearRespaldoRequest {
    @NotBlank
    private String tipo;
    @NotBlank
    private String descripcion;
}