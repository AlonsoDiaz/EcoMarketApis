package com.example.EcomarketAPIpedido.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarPedido {
    
    @NotNull
    private int id_pedido;

    @NotNull
    private String cliente;
    @NotNull
    private String estado;



}
