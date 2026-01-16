package com.example.EcoMarketApiVentas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EcoMarketApiVentas.models.entities.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}
