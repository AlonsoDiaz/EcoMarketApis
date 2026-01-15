package com.example.EcoMarketApiRutas.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarRuta {

    @NotBlank
    private String origen;

    @NotBlank
    private String destino;

    @NotNull
    private Integer distanciaKm;

    @NotNull
    private Integer duracionMin;

    @NotNull
    private Integer costoEstimado;
}
