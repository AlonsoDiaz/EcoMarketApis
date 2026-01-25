package com.example.EcomarketAPIpedido;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EcomarketAPIpedido.services.StockService;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {
    
    private final StockService stockService = new StockService();

    @Test
    void hayStock_conStock() {
        assertThat(stockService.hayStock(10)).isTrue();
    }

}