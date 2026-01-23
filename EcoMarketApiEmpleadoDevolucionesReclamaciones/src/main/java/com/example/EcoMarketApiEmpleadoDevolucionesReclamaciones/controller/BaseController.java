package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.controller;

import org.springframework.http.ResponseEntity;

public class BaseController {

    protected <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity.ok(body);
    }

    protected <T> ResponseEntity<T> notFound() {
        return ResponseEntity.notFound().build();
    }
    
}
