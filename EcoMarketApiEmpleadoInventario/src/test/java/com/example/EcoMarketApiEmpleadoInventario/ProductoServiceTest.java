package com.example.EcoMarketApiEmpleadoInventario;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Test
    void pruebaDatosProductoEcologico() {
        Producto producto = new Producto();
        producto.setNombre("Bolsas Compostables Maíz");
        producto.setStock_actual(150);
        producto.setPrecio_unitario(4500.0);
        producto.setCategoria("Hogar Sostenible");

        assertThat(producto.getNombre()).isEqualTo("Bolsas Compostables Maíz");
        assertThat(producto.getStock_actual()).isPositive();
        assertThat(producto.getCategoria()).isEqualTo("Hogar Sostenible");
    }
}