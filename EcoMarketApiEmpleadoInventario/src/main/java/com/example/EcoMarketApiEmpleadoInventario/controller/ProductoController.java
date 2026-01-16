package com.example.EcoMarketApiEmpleadoInventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;
import com.example.EcoMarketApiEmpleadoInventario.models.request.AgregarProducto;
import com.example.EcoMarketApiEmpleadoInventario.models.request.ActualizarProducto;
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

    @PostMapping
    public Producto agregarProducto(@RequestBody AgregarProducto request) {
        return productoService.agregarProducto(request);
    }

    @PutMapping
    public Producto actualizarProducto(@RequestBody ActualizarProducto request) {
        return productoService.actualizarProducto(request);
    }
}
