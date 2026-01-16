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
@Table(name = "devoluciones_reclamaciones")
public class DevolucionesReclamaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_devolucion_reclamacion;
    
    @Column(nullable = false)
    private int id_venta;
    
    @Column(nullable = false)
    private String motivo;
    
    @Column(nullable = false)
    private LocalDate fecha;
    
    @Column(nullable = false)
    private String estado;
}
