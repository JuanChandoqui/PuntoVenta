package com.visual.TiendaEspecias.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.visual.TiendaEspecias.Adapter.MariaDBAdapter;
import com.visual.TiendaEspecias.Entitys.TotalCompras;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class CompraDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public CompraDAO() {
		MariaDBAdapter adapter = MariaDBAdapter.getInstancia();
		connection = adapter.getConnection();
		//System.out.println(connection);
	}
	
	public boolean insert(TotalCompras totalCompras) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into compras values(?,?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, getAllCompras().size()+1);
				statement.setInt(2, totalCompras.getProductoID());
				statement.setString(3, totalCompras.getNombre());
				statement.setDouble(4, totalCompras.getPrecio());
				statement.setDouble(5, totalCompras.getCantidad());
				statement.setDouble(6, totalCompras.getTotalDia());
				
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public TotalCompras getTotalCompras(TotalCompras totalCompras) {
		TotalCompras totalcompras = null; 
		if (connection != null) {
			String sql = "select*from compras where ComprasID=?";			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1,totalCompras.getCompraID());
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					totalcompras = new TotalCompras();
					totalcompras.setCompraID(results.getInt(1));
					totalcompras.setProductoID(results.getInt(2));
					totalcompras.setNombre(results.getString(3));
					totalcompras.setPrecio(results.getDouble(4));
					totalcompras.setCantidad(results.getDouble(5));
					totalcompras.setTotalDia(results.getDouble(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totalcompras;
	}
	
	public ObservableList<TotalCompras> getAllCompras() {
		ObservableList<TotalCompras> compras = FXCollections.observableArrayList();
		
		if (connection != null) {
			String sql = "select * from compras";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					int compraID = results.getInt(1);
					int productoID = results.getInt(2);
					String nombre = results.getString(3);
					double precio = results.getDouble(4);
					double cantidad = results.getDouble(5);
					double total = results.getDouble(5);
					TotalCompras compraTotal = new TotalCompras(compraID, productoID,nombre,precio,cantidad,total);
					compras.add(compraTotal);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return compras;
	}
/*	
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
	*/
}