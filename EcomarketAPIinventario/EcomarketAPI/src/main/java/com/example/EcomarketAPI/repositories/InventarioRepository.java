package com.example.EcomarketAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcomarketAPI.models.entities.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    
}
