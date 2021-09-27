package com.cop.practica.models;

public class Producto  {
	
	private String codigo;
	private String nombre;
	private Double precio;
	private String observacion;
	private int categoria;
	
	public Producto() {
	}
	
	
	public Producto(String codigo, String nombre, Double precio, String observacion, int categoria) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.observacion = observacion;
		this.categoria = categoria;
	}


	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", observacion="
				+ observacion + ", categoria=" + categoria + "]";
	}
	
	
	
	

}
