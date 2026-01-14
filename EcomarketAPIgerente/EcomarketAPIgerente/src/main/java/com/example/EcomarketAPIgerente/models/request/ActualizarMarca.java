package com.example.EcomarketAPIgerente.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarMarca {

    @NotNull
    private int id;

    @NotBlank
    private String nombre;
}
