package com.example.EcoMarketApiEmpleadoInventario.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarProducto {

    @NotBlank
    private String nombre;

    @NotNull
    private Double precio_unitario;

    @NotNull
    private Integer stock_actual;
}
