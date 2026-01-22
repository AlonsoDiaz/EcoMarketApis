package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.DevolucionesReclamaciones;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request.DevolucionReclamacion;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.repositories.DevolucionReclamacionRepository;

@Service
public class DevolucionReclamacionService {

    private final DevolucionReclamacionRepository repository;

    public DevolucionReclamacionService(DevolucionReclamacionRepository repository) {
        this.repository = repository;
    }

    //POST (registrar)
    public DevolucionesReclamaciones registrar(DevolucionReclamacion request) {

        DevolucionesReclamaciones entity = new DevolucionesReclamaciones();
        entity.setIdVenta(request.getIdVenta());
        entity.setMotivo(request.getMotivo());
        entity.setFechaSolicitud(LocalDate.now());
        entity.setEstadoReclamacion("PENDIENTE");

        return repository.save(entity);
    }

    //GET (listar)
    public List<DevolucionesReclamaciones> listar() {
        return repository.findAll();
    }

    //PUT (actualizar)
    public DevolucionesReclamaciones actualizar(
            Integer id,
            DevolucionesReclamaciones datosActualizados) {

        DevolucionesReclamaciones existente = repository.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Devolución/Reclamación no encontrada"));

        existente.setMotivo(datosActualizados.getMotivo());
        existente.setEstadoReclamacion(datosActualizados.getEstadoReclamacion());

        return repository.save(existente);
    }

    //DELETE (eliminar)
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
