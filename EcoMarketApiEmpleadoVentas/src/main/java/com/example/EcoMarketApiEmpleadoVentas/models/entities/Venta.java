package main.java.com.example.EcoMarketApiEmpleadoVentas.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;

    @Column(nullable = false)
    private LocalDate fecha_venta;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private double descuento;
}