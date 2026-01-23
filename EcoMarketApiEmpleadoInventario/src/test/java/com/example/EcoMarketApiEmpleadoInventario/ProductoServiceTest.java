package com.example.EcoMarketApiEmpleadoInventario;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Test
    void pruebaDatosProducto() {
        Producto producto = new Producto();
        producto.setNombre("Arroz");
        producto.setPrecio_unitario(1500.0);

        assertThat(producto.getNombre()).isEqualTo("Arroz");
        assertThat(producto.getPrecio_unitario()).isEqualTo(1500.0);
    }
}