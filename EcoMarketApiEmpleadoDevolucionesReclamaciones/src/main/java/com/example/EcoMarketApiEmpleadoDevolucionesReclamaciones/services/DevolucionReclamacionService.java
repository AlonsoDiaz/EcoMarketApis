package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.DevolucionesReclamaciones;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.repositories.DevolucionReclamacionRepository;

@Service
public class DevolucionReclamacionService {

    @Autowired
    private DevolucionReclamacionRepository devolucionRepository;

    public List<DevolucionesReclamaciones> listarDevolucionesReclamaciones() {
        return devolucionRepository.findAll();
    }

    public DevolucionesReclamaciones buscarPorId(int id) {
        return devolucionRepository.findById(id).orElse(null);
    }

    public DevolucionesReclamaciones registrarDevolucion(DevolucionesReclamaciones request) {
        request.setFecha(LocalDate.now());
        return devolucionRepository.save(request);
    }

    public DevolucionesReclamaciones actualizarDevolucion(int id, DevolucionesReclamaciones request) {
        DevolucionesReclamaciones dev = devolucionRepository.findById(id).orElse(null);
        if (dev != null) {
            dev.setMotivo(request.getMotivo());
            dev.setEstado(request.getEstado());
            dev.setId_venta(request.getId_venta());
            return devolucionRepository.save(dev);
        }
        return null;
    }

    public String eliminarDevolucion(int id) {
        devolucionRepository.deleteById(id);
        return "Eliminado";
    }

    public List<DevolucionesReclamaciones> buscarPorEstado(String estado) {
        return devolucionRepository.findByEstado(estado);
    }

    public List<DevolucionesReclamaciones> buscarPorIdVenta(int idVenta) {
        return devolucionRepository.findById_venta(idVenta);
    }
}
