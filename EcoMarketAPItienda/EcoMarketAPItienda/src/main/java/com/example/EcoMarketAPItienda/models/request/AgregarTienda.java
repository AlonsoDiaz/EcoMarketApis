package com.example.EcoMarketAPItienda.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarTienda {

    @NotBlank
    private String horarioApertura;
    @NotBlank
    private String personalAsignado;
    @NotBlank
    private String politicasLocales;
}