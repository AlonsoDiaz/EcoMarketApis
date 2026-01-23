package com.example.EcoMarketApiEmpleadoInventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EcoMarketApiEmpleadoInventario.models.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}