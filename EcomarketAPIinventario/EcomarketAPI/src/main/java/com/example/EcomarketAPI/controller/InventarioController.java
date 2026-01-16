package com.example.EcomarketAPI.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.example.EcomarketAPI.models.entities.Inventario;
import com.example.EcomarketAPI.models.request.ActualizarInventario;
import com.example.EcomarketAPI.models.request.AgregarInventario;
import com.example.EcomarketAPI.services.InventarioService;

@RestController
@RequestMapping("inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listar() {
        return inventarioService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Inventario obtener(@PathVariable int id) {
        return inventarioService.obtenerPorId(id);
    }

    @PostMapping
    public Inventario agregar(@Valid @RequestBody AgregarInventario request) {
        return inventarioService.agregarProducto(request);
    }

    @PutMapping
    public Inventario actualizar(@Valid @RequestBody ActualizarInventario request) {
        return inventarioService.actualizarProducto(request);
    }

    @PatchMapping("/{id}/stock")
    public Inventario ajustarStock(@PathVariable int id, @RequestParam int cantidad) {
        return inventarioService.ajustarStock(id, cantidad);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return inventarioService.eliminarProducto(id);
    }
}