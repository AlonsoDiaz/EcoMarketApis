package com.example.EcoMarketApiEstadoPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketApiEstadoPedidos.models.entitites.EstadoPedido;

@Repository
public interface EstadoPedidosRepository extends JpaRepository<EstadoPedido, Integer> {
}
