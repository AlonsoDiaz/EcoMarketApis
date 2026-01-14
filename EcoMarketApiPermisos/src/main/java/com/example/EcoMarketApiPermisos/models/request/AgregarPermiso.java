package com.example.EcoMarketApiPermisos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarPermiso {

    @NotBlank
    private int userId;

    @NotBlank
    private String categoria;

    @NotBlank
    private String accion;
    
}
