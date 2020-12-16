package com.visual.TiendaEspecias.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.visual.TiendaEspecias.Adapter.MariaDBAdapter;
import com.visual.TiendaEspecias.Entitys.Producto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class ProductoDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public ProductoDAO() {
		MariaDBAdapter adapter = MariaDBAdapter.getInstancia();
		connection = adapter.getConnection();
		//System.out.println(connection);
	}
	
	public boolean insert(Producto producto) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into producto values(?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, producto.getProductoID());
				statement.setString(2, producto.getNombre());
				statement.setDouble(3, producto.getPrecio());
				statement.setDouble(4, producto.getCantidad());
				statement.setString(5, producto.getTipo());
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Producto getProducto(int productoID) {
		Producto producto = null; 
		if (connection != null) {
			String sql = "select*from producto where productoID=?";			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1,productoID);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					producto = new Producto();
					producto.setProductoID(results.getInt(1));
					producto.setNombre(results.getString(2));
					producto.setPrecio(results.getDouble(3));
					producto.setCantidad(results.getDouble(4));
					producto.setTipo(results.getString(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return producto;
	}
	
	public ObservableList<Producto> getAllProducto() {
		ObservableList<Producto> productos = FXCollections.observableArrayList();
		
		if (connection != null) {
			String sql = "select * from producto";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					int productoID = results.getInt(1);
					String nombre = results.getString(2);
					double precio = results.getDouble(3);
					double cantidad = results.getDouble(4);
					String tipo = results.getString(5);
					Producto producto = new Producto(productoID,nombre,precio,cantidad,tipo);
					productos.add(producto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return productos;
	}
	
	public boolean delete(int productoID) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from user where productoID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, productoID);
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	/*
	public boolean delete(String nombreUsuario) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from user where Nombre=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, nombreUsuario);
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	*/
	public boolean update(Producto producto) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update producto set "
					+ "Nombre=?, Precio=?, Cantidad=?, "
					+ "Tipo=?, where productoID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, producto.getNombre());
				statement.setDouble(2, producto.getPrecio());
				statement.setDouble(3, producto.getCantidad());
				statement.setString(4, producto.getTipo());
				statement.setInt(5, producto.getProductoID());
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
		
	}
}