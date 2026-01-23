package com.example.EcoMarketApiEmpleadoInventario.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;
import com.example.EcoMarketApiEmpleadoInventario.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController extends BaseController {
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        return ok(service.guardar(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable("id") int id, @RequestBody Producto producto) {
        Producto p = service.actualizar(id, producto);
        return (p != null) ? ok(p) : notFound();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        return service.eliminar(id) ? noContent() : notFound();
    }
}