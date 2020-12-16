package com.visual.TiendaEspecias.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.visual.TiendaEspecias.Adapter.MariaDBAdapter;
import com.visual.TiendaEspecias.Entitys.Producto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class InventarioDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public InventarioDAO() {
		MariaDBAdapter adapter = MariaDBAdapter.getInstancia();
		connection = adapter.getConnection();
		//System.out.println(connection);
	}
	
	public boolean insert(Producto producto) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into producto values(?,?,?,?,?)";
			String sql_2 = "insert into inventario values(?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, producto.getProductoID());
				statement.setString(2, producto.getNombre());
				statement.setDouble(3, producto.getPrecio());
				statement.setDouble(4, 1);
				statement.setString(5, producto.getTipo());
				
				PreparedStatement statement2 = connection.prepareStatement(sql_2);
				statement2.setInt(1, producto.getProductoID());
				statement2.setString(2, producto.getNombre());
				statement2.setDouble(3, producto.getPrecio());
				statement2.setString(4, producto.getTipo());
				statement2.setDouble(5, producto.getStock());
				
				if (statement.executeUpdate() == ACCEPT && statement2.executeUpdate() == ACCEPT)
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
			String sql = "select*from inventario where productoID=?";			
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
					producto.setTipo(results.getString(4));
					producto.setCantidad(results.getDouble(5));
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
			String sql = "select * from inventario";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					int productoID = results.getInt(1);
					String nombre = results.getString(2);
					double precio = results.getDouble(3);
					String tipo = results.getString(4);
					double stock = results.getDouble(5);
					Producto producto = new Producto(productoID,nombre,precio,tipo,stock);
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
			String sql = "delete from producto where productoID=?";
			String sql_2 = "delete from inventario where productoID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, productoID);
				
				PreparedStatement statement_2 = connection.prepareStatement(sql_2);
				statement_2.setInt(1, productoID);
				
				if (statement.executeUpdate() == ACCEPT && (statement_2.executeUpdate() == ACCEPT))
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public boolean updateStock(int id, double stock) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update inventario set Stock=? where productoID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setDouble(1,stock);
				statement.setDouble(2, id);
				
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
			String sql = "update producto set Nombre=?, Precio=?, Cantidad=?, Tipo=? where productoID=?";		
			String sql_2 = "update inventario set Nombre=?, Precio=?, Tipo=?, Stock=? where productoID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, producto.getNombre());
				statement.setDouble(2, producto.getPrecio());
				statement.setDouble(3, 1);
				statement.setString(4, producto.getTipo());
				statement.setInt(5, producto.getProductoID());
				
				PreparedStatement statement_2 = connection.prepareStatement(sql_2);
				statement_2.setString(1, producto.getNombre());
				statement_2.setDouble(2, producto.getPrecio());
				statement_2.setString(3, producto.getTipo());
				statement_2.setDouble(4, producto.getStock());
				statement_2.setInt(5, producto.getProductoID());
				
				if (statement.executeUpdate() == ACCEPT && (statement_2.executeUpdate() == ACCEPT))
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
		
	}
}