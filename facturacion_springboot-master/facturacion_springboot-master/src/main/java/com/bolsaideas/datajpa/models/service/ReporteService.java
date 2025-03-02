package com.bolsaideas.datajpa.models.service;

import org.springframework.stereotype.Service;

import com.bolsaideas.datajpa.models.entity.Reporte;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteService {

    private List<Reporte> reportes = new ArrayList<>();

    public void guardarReporte(Reporte reporte) {
        reportes.add(reporte);
    }

    public List<Reporte> listarReportes() {
        return reportes;
        
    }

    public void eliminarReporte(Long id) {
        reportes.removeIf(reporte -> reporte.getId().equals(id));
    }
    
}
