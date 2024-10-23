package com.bolsaideas.datajpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class ReporteController {
    @GetMapping("/reportes")
    public String mostrarReportes(Model model) {
        // Puedes agregar atributos al modelo si es necesario
        return "reportes"; // Esto buscará reportes.html en el directorio de templates
    }
}
