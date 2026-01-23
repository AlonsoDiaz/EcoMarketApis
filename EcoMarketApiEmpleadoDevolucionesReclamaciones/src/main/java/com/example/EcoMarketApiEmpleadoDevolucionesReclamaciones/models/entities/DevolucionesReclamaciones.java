package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "devoluciones_reclamaciones")
@Data
public class DevolucionesReclamaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devolucion_reclamacion")
    private Integer idDevolucionReclamacion;

    @Column(name = "id_venta", nullable = false)
    private Integer idVenta;

    @Column(nullable = false)
    private String motivo;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @Column(name = "estado_reclamacion", nullable = false)
    private String estadoReclamacion;
    
    // Metodo asignar fecha automaticamente
    @PrePersist
    public void prePersist() {
        if (this.fechaSolicitud == null) {
            this.fechaSolicitud = LocalDate.now();
        }
        if (this.estadoReclamacion == null) {
            this.estadoReclamacion = "PENDIENTE";
        }
    }
}