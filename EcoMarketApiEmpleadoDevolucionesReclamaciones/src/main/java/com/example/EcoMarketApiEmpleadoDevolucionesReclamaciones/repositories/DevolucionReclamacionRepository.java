package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.models.entities.DevolucionesReclamaciones;

@Repository
public interface DevolucionReclamacionRepository extends JpaRepository<DevolucionesReclamaciones, Integer> {

    List<DevolucionesReclamaciones> findByEstado(String estado);

    List<DevolucionesReclamaciones> findById_venta(int idVenta);
}
