package com.example.EcoMarketApiUsuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarUser {
    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
    
}
