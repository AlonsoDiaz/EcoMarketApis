package com.example.EcoMarketApiRespaldo.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "respaldos")
public class Respaldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespaldo;

   @Column(name = "tipo", nullable = false)
    private String tipo; 
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @Column(name = "fecha_respaldo", nullable = false)
    private LocalDateTime fechaRespaldo;
    
    @Column(name = "estado", nullable = false)
    private String estado; 
}