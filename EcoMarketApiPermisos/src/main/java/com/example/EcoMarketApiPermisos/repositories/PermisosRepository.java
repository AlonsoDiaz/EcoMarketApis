package com.example.EcoMarketApiPermisos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EcoMarketApiPermisos.models.entities.Permisos;

public interface PermisosRepository extends JpaRepository<Permisos, Integer> {
    
}
