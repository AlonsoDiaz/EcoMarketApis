package com.example.EcoMarketApiEmpleadoInventario.models.request;

public record InfoVersion(String nombre, double precio_unitario) {

    public InfoVersion(String appName, String version) {
        this(appName, 0.0);
    }
}
