package com.example.EcomarketAPIpedido.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarPedido {
    
    @NotNull
    private int id_pedido;

    @NotBlank
    private String cliente;
    @NotBlank
    private String estado;

    @NotBlank
    private String tienda;



}
