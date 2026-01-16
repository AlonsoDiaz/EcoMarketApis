package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.DevolucionesReclamaciones;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.services.DevolucionReclamacionService;

@RestController
@RequestMapping("/api/empleado/devoluciones")
public class DevolucionReclamacionController {

    @Autowired
    private DevolucionReclamacionService devolucionService;

    @GetMapping
    public List<DevolucionesReclamaciones> listarDevolucionesReclamaciones() {
        return devolucionService.listarDevolucionesReclamaciones();
    }

    @GetMapping("/{id}")
    public DevolucionesReclamaciones buscarDevolucion(@PathVariable int id) {
        return devolucionService.buscarPorId(id);
    }

    @PostMapping
    public DevolucionesReclamaciones registrarDevolucion(@RequestBody DevolucionesReclamaciones request) {
        return devolucionService.registrarDevolucion(request);
    }

    @PutMapping("/{id}")
    public DevolucionesReclamaciones actualizarDevolucion(@PathVariable int id, @RequestBody DevolucionesReclamaciones request) {
        return devolucionService.actualizarDevolucion(id, request);
    }

    @DeleteMapping("/{id}")
    public String eliminarDevolucion(@PathVariable int id) {
        return devolucionService.eliminarDevolucion(id);
    }
    
    @GetMapping("/estado/{estado}")
    public List<DevolucionesReclamaciones> buscarPorEstado(@PathVariable String estado) {
        return devolucionService.buscarPorEstado(estado);
    }

    @GetMapping("/venta/{idVenta}")
    public List<DevolucionesReclamaciones> buscarPorIdVenta(@PathVariable int idVenta) {
        return devolucionService.buscarPorIdVenta(idVenta);
    }
}
