package com.example.EcoMarketApiEmpleadoFacturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketApiEmpleadoFacturacion.models.entities.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}