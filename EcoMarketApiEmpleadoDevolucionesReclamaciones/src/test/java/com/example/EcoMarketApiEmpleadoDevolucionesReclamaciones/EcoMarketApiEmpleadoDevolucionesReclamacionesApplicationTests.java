package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones; 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any; 
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.DevolucionesReclamaciones;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request.DevolucionReclamacion;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.repositories.DevolucionReclamacionRepository;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services.DevolucionReclamacionService;

@ExtendWith(MockitoExtension.class)
class DevolucionReclamacionServiceTest {

    @Mock
    private DevolucionReclamacionRepository repository;

    @InjectMocks
    private DevolucionReclamacionService service;

    @Test
    void testRegistrarDevolucion() {
        DevolucionReclamacion request = new DevolucionReclamacion();
        request.setIdVenta(1);
        request.setMotivo("Producto dañado");

        DevolucionesReclamaciones entidadSimulada = new DevolucionesReclamaciones();
        entidadSimulada.setIdDevolucionReclamacion(10);
        entidadSimulada.setIdVenta(1);
        entidadSimulada.setMotivo("Producto dañado");

        when(repository.save(any())).thenReturn(entidadSimulada);

        DevolucionesReclamaciones resultado = service.registrar(request);

        assertNotNull(resultado);
        assertEquals(10, resultado.getIdDevolucionReclamacion());
        assertEquals("Producto dañado", resultado.getMotivo());
    
        verify(repository).save(any());
    }
}