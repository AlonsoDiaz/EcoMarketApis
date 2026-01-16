package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DevolucionRequest {

    @NotBlank
    private int id_venta;

    @NotBlank
    private String motivo;

    @NotBlank
    private int cantidad_de_vuelta;
}
