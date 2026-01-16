package com.example.EcoMarketApiEmpleadoInventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;
import com.example.EcoMarketApiEmpleadoInventario.models.request.ActualizarProducto;
import com.example.EcoMarketApiEmpleadoInventario.models.request.AgregarProducto;
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

    public Producto agregarProducto(AgregarProducto request) {
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setPrecio_unitario(request.getPrecio_unitario());
        producto.setStock_actual(request.getStock_actual());
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(ActualizarProducto request) {
        Producto producto = productoRepository.findById(request.getId_producto()).orElse(null);
        if (producto != null) {
            producto.setNombre(request.getNombre());
            producto.setPrecio_unitario(request.getPrecio_unitario());
            producto.setStock_actual(request.getStock_actual());
            return productoRepository.save(producto);
        }
        return null;
    }
}
