package com.example.EcomarketAPIreportes.Services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcomarketAPIreportes.models.entities.Reportes;
import com.example.EcomarketAPIreportes.models.request.ActualizarReportes;
import com.example.EcomarketAPIreportes.models.request.AgregarReportes;
import com.example.EcomarketAPIreportes.repositories.ReportesRepository;

@Service
public class ReportesService {

    @Autowired
    private ReportesRepository reportesRepository;

    public List<Reportes> obtenerTodos() {
        return reportesRepository.findAll();
    }

    public Reportes obtenerPorId(int id) {
        return reportesRepository.findById(id).orElse(null);
    }

    public Reportes crearReporte(AgregarReportes request) {
        Reportes reporte = new Reportes();
        reporte.setTipo(request.getTipo());
        reporte.setFecha(request.getFecha());
        return reportesRepository.save(reporte);
    }

    public Reportes actualizarReporte(ActualizarReportes request) {
        return reportesRepository.findById(request.getIdReporte().intValue()).map(reporte -> {
            reporte.setTipo(request.getTipo());
            reporte.setFecha(request.getFecha());
            return reportesRepository.save(reporte);
        }).orElse(null);
    }

    public String eliminarReporte(int id) {
        if (reportesRepository.existsById(id)) {
            reportesRepository.deleteById(id);
            return "Reporte eliminado";
        }
        return "No encontrado";
    }
}