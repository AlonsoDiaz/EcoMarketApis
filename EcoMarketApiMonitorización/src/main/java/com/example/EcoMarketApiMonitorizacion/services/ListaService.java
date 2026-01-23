package com.example.EcoMarketApiMonitorizacion.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListaService {
    
    public int contarElementos(List<String> lista){
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }

}
