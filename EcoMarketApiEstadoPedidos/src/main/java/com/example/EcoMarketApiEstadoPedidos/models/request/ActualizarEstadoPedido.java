package com.example.EcoMarketApiEstadoPedidos.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ActualizarEstadoPedido {

    @NotNull
    @Positive
    private Integer id;

    @NotNull
    @Positive
    private Integer pedidoId;

    @NotNull
    @Positive
    private Integer idEnvio;

    @NotBlank
    private String estado;
}
