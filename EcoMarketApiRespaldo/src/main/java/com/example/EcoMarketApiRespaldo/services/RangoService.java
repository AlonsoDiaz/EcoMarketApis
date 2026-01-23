
package com.example.EcoMarketApiRespaldo.services;

import org.springframework.stereotype.Service;

@Service
public class RangoService {

    public boolean dentroDeRango(int numero) {
        return numero >= 1 && numero <= 100;
    }
    
}
