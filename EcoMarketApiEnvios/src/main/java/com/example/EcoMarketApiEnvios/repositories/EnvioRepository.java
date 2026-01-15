package com.example.EcoMarketApiEnvios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketApiEnvios.models.entities.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer> {
}
