package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services;

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

    public List<DevolucionesReclamaciones> listar() {
        return repository.findAll();
    }

    public DevolucionesReclamaciones buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public DevolucionesReclamaciones registrar(DevolucionReclamacion request) {
        DevolucionesReclamaciones entidad = new DevolucionesReclamaciones();
        entidad.setIdVenta(request.getIdVenta());
        entidad.setMotivo(request.getMotivo());
        return repository.save(entidad);
    }

    public DevolucionesReclamaciones actualizar(Integer id, DevolucionReclamacion request) {
        DevolucionesReclamaciones existente = repository.findById(id).orElse(null);
        
        if (existente != null) {
            existente.setIdVenta(request.getIdVenta());
            existente.setMotivo(request.getMotivo());
            return repository.save(existente);
        }
        return null;
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}