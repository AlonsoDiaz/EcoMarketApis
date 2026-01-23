package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DevolucionReclamacion {

    @NotNull(message = "El ID de venta es obligatorio")
    private Integer idVenta;

    @NotNull(message = "El motivo es obligatorio")
    private String motivo;
}