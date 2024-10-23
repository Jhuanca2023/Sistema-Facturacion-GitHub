package com.bolsaideas.datajpa.models.entity;

import java.time.LocalDateTime;

public class Reporte {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private LocalDateTime fecha;
    private String productos; // Puedes usar una lista o una cadena separada
    private double montoTotal;
    // Getters y Setters
	public Reporte() {
		super();
	}
	public Reporte(Long id, String nombre, String apellido, String dni, String email, LocalDateTime fecha,
			String productos, double montoTotal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.fecha = fecha;
		this.productos = productos;
		this.montoTotal = montoTotal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getProductos() {
		return productos;
	}
	public void setProductos(String productos) {
		this.productos = productos;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
    
    
}