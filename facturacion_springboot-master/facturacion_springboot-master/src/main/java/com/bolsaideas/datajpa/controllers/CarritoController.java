package com.bolsaideas.datajpa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bolsaideas.datajpa.models.entity.Producto;
import com.bolsaideas.datajpa.models.entity.Reporte;
import com.bolsaideas.datajpa.models.service.CarritoService;
import com.bolsaideas.datajpa.models.service.ReporteService;

import java.util.List;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/listar")
    public String listarCarrito(Model model) {
        List<Producto> productosCarrito = carritoService.getProductosCarrito();
        double totalCarrito = carritoService.calcularTotal();
        model.addAttribute("productosCarrito", productosCarrito);
        model.addAttribute("totalCarrito", totalCarrito);
        return "carrito";
    }

    @GetMapping("/agregar/{id}")
    public String agregarAlCarrito(@PathVariable Long id) {
        carritoService.agregarProducto(id);
        return "redirect:/carrito/listar";
    }

    @PostMapping("/reportes")
    public String generarReporte(@ModelAttribute Reporte reporte) {
        reporteService.guardarReporte(reporte);
        carritoService.limpiarCarrito();
        return "redirect:/reportes/listar";  // Redirige a la lista de reportes después de realizar la compra
    }
    @GetMapping("/reportes")
    public String listarReportes(Model model) {
        List<Reporte> reportes = reporteService.listarReportes(); // Obtiene todos los reportes
        model.addAttribute("reportes", reportes);
        return "reportes";  // Retorna a la vista 'reportes.html'
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarDelCarrito(@PathVariable Long id) {
        carritoService.eliminarProducto(id);
        return "redirect:/carrito/listar";
    }
}
