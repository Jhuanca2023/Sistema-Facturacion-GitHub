package com.bolsaideas.datajpa.models.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bolsaideas.datajpa.models.dao.IProductoDao; // Importar tu repositorio
import com.bolsaideas.datajpa.models.entity.Producto; // Importar tu entidad Producto
import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {

    private List<Producto> productosCarrito = new ArrayList<>();

    @Autowired
    private IProductoDao productoDao; // Inyectar tu repositorio

    public void agregarProducto(Long id) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            productosCarrito.add(producto);
        }
    }

    public void eliminarProducto(Long id) {
        productosCarrito.removeIf(producto -> producto.getId().equals(id));
    }

    public List<Producto> getProductosCarrito() {
        return productosCarrito;
    }

    public void limpiarCarrito() {
        productosCarrito.clear();
    }

    public double calcularTotal() {
        return productosCarrito.stream().mapToDouble(Producto::getPrecio).sum();
    }

    // Método para buscar un producto por ID
    private Producto buscarProductoPorId(Long id) {
        return productoDao.findById(id).orElse(null);
    }
}