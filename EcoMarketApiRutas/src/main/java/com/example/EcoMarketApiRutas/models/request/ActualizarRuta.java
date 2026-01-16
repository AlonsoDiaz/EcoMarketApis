package com.example.EcoMarketApiRutas.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarRuta {

    @NotNull
    private Integer idRuta;

    private String origen;

    private String destino;

    private Integer distanciaKm;

    private Integer duracionMin;

    private Integer costoEstimado;

    private String estado;
}
