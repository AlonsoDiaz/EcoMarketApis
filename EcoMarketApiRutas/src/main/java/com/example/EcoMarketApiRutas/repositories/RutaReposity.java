package com.example.EcoMarketApiRutas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EcoMarketApiRutas.models.entities.Ruta;

public interface RutaReposity extends JpaRepository<Ruta, Integer> {
}
