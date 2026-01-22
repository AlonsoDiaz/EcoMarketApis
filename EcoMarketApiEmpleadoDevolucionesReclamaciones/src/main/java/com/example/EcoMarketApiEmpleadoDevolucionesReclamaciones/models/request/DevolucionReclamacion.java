package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DevolucionReclamacion {

    @NotNull
    private Integer idVenta;

    @NotBlank
    private String motivo;
}
