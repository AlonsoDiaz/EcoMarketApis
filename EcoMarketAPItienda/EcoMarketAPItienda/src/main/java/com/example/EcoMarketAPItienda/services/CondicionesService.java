package com.example.EcoMarketAPItienda.services;   

import org.springframework.stereotype.Service;

@Service
public class CondicionesService {
    
    public boolean mayorEdad(int edad){
        return edad >=18;
    }
}
