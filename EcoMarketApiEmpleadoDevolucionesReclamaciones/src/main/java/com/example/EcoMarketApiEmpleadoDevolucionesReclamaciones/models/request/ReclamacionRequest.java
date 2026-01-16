package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReclamacionRequest {

    @NotBlank
    private int id_venta;

    @NotBlank
    private String descripcion;
}
