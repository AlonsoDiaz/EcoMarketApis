package com.example.EcoMarketApiEstadoPedidos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EcoMarketApiEstadoPedidos.services.StockService;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {
    
    private final StockService stockService = new StockService();

    @Test
void hayStock_conStock() {
    assertThat(stockService.hayStock(10)).isTrue();
}

}
