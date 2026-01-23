package com.example.EcomarketAPIreportes.models.request;

public record InfoVersion(String tipo, String fecha) {

    public InfoVersion (String tipo, String fecha){
        this.tipo = tipo;
        this.fecha = fecha;
    }}