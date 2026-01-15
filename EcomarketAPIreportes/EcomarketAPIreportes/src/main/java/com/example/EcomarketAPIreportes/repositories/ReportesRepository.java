package com.example.EcomarketAPIreportes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcomarketAPIreportes.models.entities.Reportes;

@Repository
public interface ReportesRepository extends JpaRepository<Reportes, Integer> {
    
}
