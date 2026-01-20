package com.example.EcoMarketApiPermisos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EcoMarketApiPermisos.services.MenorEdadService;


@ExtendWith(MockitoExtension.class)
public class MenorEdadServiceTest {

    private final MenorEdadService servicio = new MenorEdadService();

    @Test
    void pruebasMenorEdad(){
        boolean resultado = servicio.menorEdad(17);
        assertThat(resultado).isTrue();
    }
    
}
