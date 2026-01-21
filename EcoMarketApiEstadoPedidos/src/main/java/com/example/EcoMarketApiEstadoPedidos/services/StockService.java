package com.example.EcoMarketApiEstadoPedidos.services;

import org.springframework.stereotype.Service;

@Service
public class StockService {

    public boolean hayStock(int stock) {
        return stock > 0;
    }
    
}
