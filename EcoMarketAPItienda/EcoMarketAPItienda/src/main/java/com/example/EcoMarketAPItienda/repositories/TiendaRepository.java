package com.example.EcoMarketAPItienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketAPItienda.models.entities.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
}
