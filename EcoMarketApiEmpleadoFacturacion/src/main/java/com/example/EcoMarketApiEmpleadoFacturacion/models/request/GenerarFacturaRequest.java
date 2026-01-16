package com.example.EcoMarketApiEmpleadoFacturacion.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GenerarFacturaRequest {

    @NotNull
    private Integer id_venta;

    @NotNull
    private Double total_facturado;

    @NotBlank
    private String correo_cliente;
}
