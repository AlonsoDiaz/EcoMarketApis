package com.example.EcoMarketApiProveedores.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AgregarProveedor {

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    private String contacto;

    @NotBlank
    @Size(max = 20)
    private String telefono;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 200)
    private String direccion;

    @Positive
    private int minimoPedido;

    @NotBlank
    @Size(max = 200)
    private String condiciones;

    @Size(max = 250)
    private String notasRecepcion;

    @NotNull
    private Boolean activo;
}
