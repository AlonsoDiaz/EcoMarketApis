package com.example.EcoMarketApiEmpleadoInventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;
import com.example.EcoMarketApiEmpleadoInventario.services.ProductoService;

@RestController
@RequestMapping("/api/empleado/inventario")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto buscarProducto(@PathVariable int id) {
        return productoService.buscarPorId(id);
    }
}
