package com.example.EcoMarketAPItienda.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarTienda {
    @NotNull private int idTienda;

    @NotBlank
    private String horarioApertura;
    @NotBlank
    private String personalAsignado;
    @NotBlank
    private String politicasLocales;

}
