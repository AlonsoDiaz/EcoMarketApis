package com.example.EcomarketAPIgerente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcomarketAPIgerente.models.entities.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository <Gerente, Integer> {
}
