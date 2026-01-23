package com.example.EcoMarketAPItienda.models.request;

public record InfoVersion(String horarioApertura, String horarioCierre, String personalAsignado) {

    public InfoVersion(String appName, String version){
        this(appName, version, "");
    }
} 