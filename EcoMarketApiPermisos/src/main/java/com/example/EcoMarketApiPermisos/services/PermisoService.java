package com.example.EcoMarketApiPermisos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiPermisos.models.entities.Permisos;
import com.example.EcoMarketApiPermisos.models.request.ActualizarPermisos;
import com.example.EcoMarketApiPermisos.models.request.AgregarPermiso;
import com.example.EcoMarketApiPermisos.repositories.PermisosRepository;

@Service
public class PermisoService {

    @Autowired
    private PermisosRepository permisosRepository;
    
    public List<Permisos> obtenerTodosLosPermisos() {
        return permisosRepository.findAll();
    }

    public Permisos ObtenerPermisoPorId(int idPermiso) {
        Permisos permisos = permisosRepository.findById(idPermiso).orElse(null);
        if (permisos == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado.");
 
        }
        return permisos;

    }

    public Permisos agregarPermiso(AgregarPermiso nuevo){
        Permisos permiso = new Permisos();
        permiso.setCategoria(nuevo.getCategoria());
        permiso.setAccion(nuevo.getAccion());

        return permisosRepository.save(permiso);
    }

    public Permisos actualizarPermiso(ActualizarPermisos nueva){
        Permisos permisos = permisosRepository.findById(nueva.getId_permiso()).orElse(null);
        if (permisos == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado.");
 
        }else{
        
            permisos.setCategoria(nueva.getCategoria());
            permisos.setAccion(nueva.getAccion());

            return permisosRepository.save(permisos);
        }

        
    }

    public String eliminarPermiso(int idPermiso){
        if (permisosRepository.existsById(idPermiso)) {
            permisosRepository.deleteById(idPermiso);
            return "Permiso eliminado correctamente.";
            
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado.");
        }
    }
}
