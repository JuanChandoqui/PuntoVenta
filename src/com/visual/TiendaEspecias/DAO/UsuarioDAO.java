package com.visual.TiendaEspecias.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.visual.TiendaEspecias.Adapter.MariaDBAdapter;
import com.visual.TiendaEspecias.Entitys.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsuarioDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public UsuarioDAO() {
		MariaDBAdapter adapter = MariaDBAdapter.getInstancia();
		connection = adapter.getConnection();
		//System.out.println(connection);
	}
	
	public boolean insert(Usuario usuario) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into usuario values(?,?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, usuario.getUsuarioID());
				statement.setString(2, usuario.getNombre());
				statement.setString(3, usuario.getApellidoMaterno());
				statement.setString(4, usuario.getApellidoPaterno());
				statement.setString(5, usuario.getNombreUsuario());
				statement.setString(6, usuario.getContrasena());
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Usuario getUsuario(String nombreUsuario) {
		Usuario usuario = null; 
		if (connection != null) {
			String sql = "select*from usuario where NombreUsuario=?";			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1,nombreUsuario);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					usuario = new Usuario();
					usuario.setUsuarioID(results.getInt(1));
					usuario.setNombre(results.getString(2));
					usuario.setApellidoMaterno(results.getString(3));
					usuario.setApellidoPaterno(results.getString(4));
					usuario.setNombreUsuario(results.getString(5));
					usuario.setContrasena(results.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return usuario;
	}
	
	public ObservableList<Usuario> getAllUsuario() {
		ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
		
		if (connection != null) {
			String sql = "select * from usuario";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					int usuarioID = results.getInt(1);
					String nombre = results.getString(2);
					String apellidoPaterno = results.getString(3);
					String apellidoMaterno = results.getString(4);
					String nombreUsuario = results.getString(5);
					String contrasena = results.getString(6);
					Usuario user = new Usuario(usuarioID,nombre,apellidoPaterno,apellidoMaterno,nombreUsuario,contrasena);
					usuarios.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return usuarios;
	}
	
	public boolean delete(int usuarioID) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from usuario where usuarioID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, usuarioID);
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
			String sql = "delete from usuario where nombre=?";
			
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
	
	public boolean update(Usuario usuario) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update usuario set Nombre=?, ApellidoMaterno=?, ApellidoPaterno=?, NombreUsuario=?, Contrasena=? where UsuarioID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, usuario.getNombre());
				statement.setString(2, usuario.getApellidoMaterno());
				statement.setString(3, usuario.getApellidoPaterno());
				statement.setString(4, usuario.getNombreUsuario());
				statement.setString(5, usuario.getContrasena());
				statement.setInt(6, usuario.getUsuarioID());
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