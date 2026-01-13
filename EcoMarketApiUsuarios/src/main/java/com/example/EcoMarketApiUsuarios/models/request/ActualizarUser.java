package com.example.EcoMarketApiUsuarios.models.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarUser {
    
    @NotBlank
    private int id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
    

}
