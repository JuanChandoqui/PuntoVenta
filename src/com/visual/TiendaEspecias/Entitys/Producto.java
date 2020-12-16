package com.visual.TiendaEspecias.Entitys;

public class Producto {
	private int productoID;
	private String nombre;
	private double precio;
	private double cantidad;
	private String tipo;
	private double stock;
	
	public Producto() {
		
	}
	
	public Producto(int productoID, String nombre, double precio, double cantidad, String tipo) {
		this.productoID = productoID;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.tipo = tipo;
	}
	
	public Producto(int productoID, String nombre, double precio, String tipo, double stock) {
		this.productoID = productoID;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.tipo = tipo;
	}
	
	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public int getProductoID() {
		return productoID;
	}
	public void setProductoID(int productoID) {
		this.productoID = productoID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
