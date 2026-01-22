package com.example.EcomarketAPIpedido.models.request;

public record InfoVersion(String cliente, String estado, String tienda) {

        public InfoVersion(String appName, String version){
            this(appName, version, "");
        }


} 
