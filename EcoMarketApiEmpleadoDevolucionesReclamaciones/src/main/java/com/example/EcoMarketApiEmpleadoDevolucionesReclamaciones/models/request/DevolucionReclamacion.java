package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request;

import java.time.LocalDate;
import java.util.List;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.DevolucionesReclamaciones;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DevolucionReclamacion {

    @NotNull
    private Integer id_venta;

    @NotBlank
    private String motivo;

    @NotNull
    private LocalDate fecha;
    
    @NotBlank
    private String estado;

    public List<DevolucionesReclamaciones> listarDevolucionesReclamaciones() {
        throw new UnsupportedOperationException("Unimplemented method 'listarDevolucionesReclamaciones'");
    }

    public DevolucionesReclamaciones buscarPorId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    public DevolucionesReclamaciones registrarDevolucion(DevolucionReclamacion request) {
        throw new UnsupportedOperationException("Unimplemented method 'registrarDevolucion'");
    }

    public DevolucionesReclamaciones actualizarDevolucion(int id, DevolucionReclamacion request) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizarDevolucion'");
    }

    public String eliminarDevolucion(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminarDevolucion'");
    }

    public List<DevolucionesReclamaciones> buscarPorEstado(String estado2) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorEstado'");
    }

    public List<DevolucionesReclamaciones> buscarPorIdVenta(int idVenta) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorIdVenta'");
    }
}
