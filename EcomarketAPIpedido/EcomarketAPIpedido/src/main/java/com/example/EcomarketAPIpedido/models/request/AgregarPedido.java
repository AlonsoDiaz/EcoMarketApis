package com.example.EcomarketAPIpedido.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarPedido {
    @NotBlank
    private String cliente;
    @NotBlank
    private String estado;
    @NotBlank
    private String tienda;
}
