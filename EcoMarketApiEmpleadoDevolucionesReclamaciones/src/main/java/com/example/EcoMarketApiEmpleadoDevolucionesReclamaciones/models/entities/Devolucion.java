package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "devolucion")
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_devolucion;
    
    @Column(nullable = false)
    private int id_venta;
    
    @Column(nullable = false)
    private String motivo;
    
    @Column(nullable = false)
    private LocalDate fecha_devolucion;
    
    @Column(nullable = false)
    private int cantidad_de_vuelta;

}
