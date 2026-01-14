package com.example.EcomarketAPIgerente.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarMarca {
    @NotBlank
    private String nombre;



}