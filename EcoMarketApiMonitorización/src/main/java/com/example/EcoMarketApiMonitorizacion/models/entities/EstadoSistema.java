package com.example.EcoMarketApiMonitorizacion.models.entities;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "estado_sistema")
public class EstadoSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estadoSistema;

    @Column(name = "estado")
    private String estado;
    @Column(name = "uso_cpu")        
    private Integer usoCpu;       
    @Column(name = "uso_memoria")
    private Integer usoMemoria;
    @Column(name = "mensaje")   
    private String mensaje; 
    
}
