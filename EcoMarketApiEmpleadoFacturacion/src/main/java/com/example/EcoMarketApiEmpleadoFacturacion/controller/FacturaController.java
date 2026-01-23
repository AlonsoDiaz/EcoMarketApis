package com.example.EcoMarketApiEmpleadoFacturacion.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcoMarketApiEmpleadoFacturacion.models.entities.Factura;
import com.example.EcoMarketApiEmpleadoFacturacion.services.FacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaController extends BaseController {
    private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Factura>> listar() {
        return ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Factura> crear(@RequestBody Factura factura) {
        return ok(service.guardar(factura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable("id") int id, @RequestBody Factura factura) {
        Factura a = service.actualizar(id, factura);
        return (a != null) ? ok(a) : notFound();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        return service.eliminar(id) ? noContent() : notFound();
    }
}