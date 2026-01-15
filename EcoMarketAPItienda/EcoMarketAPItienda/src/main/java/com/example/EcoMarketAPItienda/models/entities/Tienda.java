package com.example.EcoMarketAPItienda.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tiendas")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

  
    @Column(name = "horario_apertura", nullable = false)
    private String horarioApertura;


    @Column(name = "personal_asignado", nullable = false)
    private String personalAsignado;

 
    @Column(name = "politicas_locales", columnDefinition = "TEXT")
    private String politicasLocales;
}