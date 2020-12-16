package com.visual.TiendaEspecias.Entitys;

public class TotalCompras {
	private int compraID;
	private int productoID;
	private String nombre;
	private double cantidad;
	private double precio;
	private String tipo;
	private double totalDia;
	
	public TotalCompras() {
		
	}

	public TotalCompras(int compraID, int productoID, String nombre, double cantidad, double precio, double totalDia) {
		this.compraID = compraID;
		this.productoID = productoID;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.totalDia = totalDia;
	}


	public int getCompraID() {
		return compraID;
	}

	public void setCompraID(int compraID) {
		this.compraID = compraID;
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

	public double getTotalDia() {
		return totalDia;
	}

	public void setTotalDia(double totalDia) {
		this.totalDia = totalDia;
	}
	public void calcularTotalDia(double total) {
		totalDia += total;
	}
	
	
}
