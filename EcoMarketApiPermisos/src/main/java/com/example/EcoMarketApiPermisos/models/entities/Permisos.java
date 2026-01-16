package com.example.EcoMarketApiPermisos.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "permisos")
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_permiso;


    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "accion", nullable = false)
    private String accion;
}
