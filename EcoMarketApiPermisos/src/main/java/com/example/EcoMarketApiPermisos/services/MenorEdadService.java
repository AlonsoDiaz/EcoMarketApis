package com.example.EcoMarketApiPermisos.services;

import org.springframework.stereotype.Service;

@Service
public class MenorEdadService {

    public boolean menorEdad(int edad){
        return edad < 18;
    }
    
}
