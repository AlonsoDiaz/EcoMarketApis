package com.example.EcoMarketApiMonitorizacion.models.request;


import lombok.Data;

@Data
public class AgregarEstadoSistema {

    private String estado;
    private int usoCpu;
    private int usoMemoria;
    private String mensaje;
}
