package com.example.EcoMarketApiEmpleadoInventario.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;
import com.example.EcoMarketApiEmpleadoInventario.repositories.ProductoRepository;

@Service
public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizar(int id, Producto datos) {
        return repository.findById(id).map(p -> {
            p.setNombre(datos.getNombre());
            p.setStock_actual(datos.getStock_actual());
            p.setPrecio_unitario(datos.getPrecio_unitario());
            p.setCategoria(datos.getCategoria());
            return repository.save(p);
        }).orElse(null);
    }

    public boolean eliminar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}