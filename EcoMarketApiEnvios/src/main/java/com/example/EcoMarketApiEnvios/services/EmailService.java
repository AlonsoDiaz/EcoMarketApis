package com.example.EcoMarketApiEnvios.services;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public boolean emailValido(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
}
