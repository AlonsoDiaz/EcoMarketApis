package com.example.EcoMarketApiMonitorizacion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.EcoMarketApiMonitorizacion.services.ListaService;

@ExtendWith(MockitoExtension.class)
public class ListaServiceTest {

    private final ListaService servicio = new ListaService();
    
    @Test
    void pruebaContarElementos() {
        List<String> lista = List.of("Elemento1", "Elemento2", "Elemento3");
        int resultado = servicio.contarElementos(lista);

        assertThat(resultado).isEqualTo(3);
    }
}
