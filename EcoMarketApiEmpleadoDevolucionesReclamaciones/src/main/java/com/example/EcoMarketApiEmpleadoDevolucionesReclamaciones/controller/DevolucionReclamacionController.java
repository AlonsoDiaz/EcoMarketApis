package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.DevolucionesReclamaciones;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.request.DevolucionReclamacion;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services.DevolucionReclamacionService;

@RestController
@RequestMapping("/devoluciones-reclamaciones")
public class DevolucionReclamacionController extends BaseController {

    private final DevolucionReclamacionService service;

    public DevolucionReclamacionController(DevolucionReclamacionService service) {
        this.service = service;
    }

    //GET (listar)
    @GetMapping
    public ResponseEntity<List<DevolucionesReclamaciones>> listar() {
        return ok(service.listar());
    }

    //POST (registrar)
    @PostMapping
    public ResponseEntity<DevolucionesReclamaciones> registrar(
            @RequestBody @Valid DevolucionReclamacion request) {
        return ok(service.registrar(request));
    }

    //PUT (actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<DevolucionesReclamaciones> actualizar(
            @PathVariable Integer id,
            @RequestBody DevolucionesReclamaciones body) {

        return ok(service.actualizar(id, body));
    }

    //DELETE (eliminar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return noContent();
    }
}
