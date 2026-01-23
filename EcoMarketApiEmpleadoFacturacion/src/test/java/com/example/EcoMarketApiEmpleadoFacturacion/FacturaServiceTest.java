package com.example.EcoMarketApiEmpleadoFacturacion;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.EcoMarketApiEmpleadoFacturacion.models.entities.Factura;

@ExtendWith(MockitoExtension.class)
public class FacturaServiceTest {

    @Test
    void pruebaDatosFacturacionEcoMarket() {
        Factura factura = new Factura();
        factura.setId_venta(5050);
        factura.setTotal_facturado(25990.0);
        factura.setCorreo_cliente("n.lastarria@ecomarket.cl");

        assertThat(factura.getTotal_facturado()).isGreaterThan(0);
        assertThat(factura.getCorreo_cliente()).isEqualTo("n.lastarria@ecomarket.cl");
        assertThat(factura.getId_venta()).isEqualTo(5050);
    }
}