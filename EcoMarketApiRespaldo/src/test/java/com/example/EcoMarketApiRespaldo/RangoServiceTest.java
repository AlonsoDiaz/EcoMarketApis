package com.example.EcoMarketApiRespaldo;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EcoMarketApiRespaldo.services.RangoService;

@ExtendWith(MockitoExtension.class)
public class RangoServiceTest {

    private final RangoService servicio = new RangoService();

    @Test
    void testDentroDeRango_ValorValido() {
        int numero = 50;
        boolean resultado = servicio.dentroDeRango(numero);
        assertThat(resultado).isTrue();
    }
    
}
