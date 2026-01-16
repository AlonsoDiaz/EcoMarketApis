package com.example.EcoMarketApiEmpleadoFacturacion.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FacturaRequest {

    @NotBlank
    private int id_venta;

    @NotBlank
    private double total_facturado;

    @NotBlank
    private String correo_cliente;
}
