package com.visual.TiendaEspecias.Entitys;

import java.util.ArrayList;

public class Inventario {
	private double stock;
	private ArrayList<Producto> productos;
	
	public Inventario() {
		
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}	
	
}
