package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.DevolucionesReclamaciones;

@ExtendWith(MockitoExtension.class)
public class DevolucionServiceTest {

    @Test
    void pruebaRegistroDevolucion() {
        DevolucionesReclamaciones devolucion = new DevolucionesReclamaciones();
        
        devolucion.setIdVenta(101);
        devolucion.setMotivo("Producto dañado: Envase de detergente ecológico roto");
        devolucion.setEstadoReclamacion("Pendiente");
        devolucion.setFechaSolicitud(LocalDate.now());

        assertThat(devolucion.getIdVenta()).isEqualTo(101);
        assertThat(devolucion.getMotivo()).contains("detergente");
        assertThat(devolucion.getEstadoReclamacion()).isEqualTo("Pendiente");
        assertThat(devolucion.getFechaSolicitud()).isNotNull();
    }
}