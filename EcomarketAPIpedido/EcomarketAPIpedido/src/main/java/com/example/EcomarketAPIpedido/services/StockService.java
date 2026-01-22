package com.example.EcomarketAPIpedido.services;

import org.springframework.stereotype.Service;

@Service
public class StockService {

    public boolean hayStock(int stock) {
        return stock > 0;
    }
}
