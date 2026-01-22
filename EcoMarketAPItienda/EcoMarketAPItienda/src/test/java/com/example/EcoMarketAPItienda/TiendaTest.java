package com.example.EcoMarketAPItienda;



import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.EcoMarketAPItienda.models.entities.Tienda;

@ExtendWith(MockitoExtension.class)
public class TiendaTest {

    @Test
    void pruebaHorarioTienda() {
        Tienda tienda = new Tienda();
        tienda.setHorarioApertura("09:00");

        assertThat(tienda.getHorarioApertura()).isEqualTo("09:00");
    }
}