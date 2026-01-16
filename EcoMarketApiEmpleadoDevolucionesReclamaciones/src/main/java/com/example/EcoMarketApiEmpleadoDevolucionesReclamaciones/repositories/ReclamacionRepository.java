package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.Reclamacion;

@Repository
public interface ReclamacionRepository extends JpaRepository<Reclamacion, Integer> {
}
