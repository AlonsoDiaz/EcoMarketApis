package com.example.EcomarketAPI.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcomarketAPI.models.entities.Inventario;
import com.example.EcomarketAPI.models.request.ActualizarInventario;
import com.example.EcomarketAPI.models.request.AgregarInventario;
import com.example.EcomarketAPI.repositories.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> obtenerTodo() {
        return inventarioRepository.findAll();
    }

    public Inventario obtenerPorId(int id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public Inventario agregarProducto(AgregarInventario request) {
        Inventario producto = new Inventario();
        producto.setNombreProducto(request.getNombreProducto());
        producto.setCantidadStock(request.getCantidadStock());
        producto.setCategoria(request.getCategoria());
        producto.setPrecio(request.getPrecio());
        return inventarioRepository.save(producto);
    }

    public Inventario actualizarProducto(ActualizarInventario request) {
        return inventarioRepository.findById(request.getIdProducto().intValue()).map(producto -> {
            producto.setNombreProducto(request.getNombreProducto());
            producto.setCantidadStock(request.getCantidadStock());
            producto.setCategoria(request.getCategoria());
            producto.setPrecio(request.getPrecio());
            return inventarioRepository.save(producto);
        }).orElse(null);
    }

    public Inventario ajustarStock(int id, int nuevaCantidad) {
        return inventarioRepository.findById(id).map(producto -> {
            producto.setCantidadStock(nuevaCantidad);
            return inventarioRepository.save(producto);
        }).orElse(null);
    }

    public String eliminarProducto(int id) {
        if (inventarioRepository.existsById(id)) {
            inventarioRepository.deleteById(id);
            return "Producto eliminado";
        }
        return "No encontrado";
    }
}