package com.example.EcoMarketApiPermisos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarPermisos {

    @NotBlank
    private int id_permiso;


    @NotBlank
    private String categoria;

    @NotBlank
    private String accion;
    
}
