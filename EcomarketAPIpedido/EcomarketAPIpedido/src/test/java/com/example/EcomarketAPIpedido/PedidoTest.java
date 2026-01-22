package com.example.EcomarketAPIpedido;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.example.EcomarketAPIpedido.models.entities.Pedido;

public class PedidoTest {
    @Test
    void pruebaEstadoPedido() {
        Pedido pedido = new Pedido();
        pedido.setEstado("PENDIENTE");
        assertThat(pedido.getEstado()).isEqualTo("PENDIENTE");
    }
}