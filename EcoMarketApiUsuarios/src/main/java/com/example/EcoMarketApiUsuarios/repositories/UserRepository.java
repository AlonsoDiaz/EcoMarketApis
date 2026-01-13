package com.example.EcoMarketApiUsuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketApiUsuarios.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
    
}
