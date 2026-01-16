package com.example.EcoMarketApiMonitorizacion.repositories;

import com.example.EcoMarketApiMonitorizacion.models.entities.EstadoSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoSistemaRepository extends JpaRepository<EstadoSistema, Integer> {
}
