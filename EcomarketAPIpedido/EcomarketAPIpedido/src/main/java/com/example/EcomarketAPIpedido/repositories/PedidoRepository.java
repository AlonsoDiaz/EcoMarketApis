package com.example.EcomarketAPIpedido.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcomarketAPIpedido.models.intities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer>{}

    
