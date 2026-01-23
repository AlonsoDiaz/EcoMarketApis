package com.example.EcoMarketApiUsuarios;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EcoMarketApiUsuarios.services.CondicionesService;

@ExtendWith(MockitoExtension.class)
public class CondicionesServiceTest {
    
    private final CondicionesService servicio = new CondicionesService();
    
    @Test
    void pruebaCondiciones(){

        boolean resultado = servicio.mayorEdad(18);
        assertThat(resultado).isTrue();
    }

}
