package com.example.EcoMarketApiEmpleadoInventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;
import com.example.EcoMarketApiEmpleadoInventario.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }
}
