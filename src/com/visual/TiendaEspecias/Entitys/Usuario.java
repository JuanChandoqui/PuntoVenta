package com.visual.TiendaEspecias.Entitys;

public class Usuario {

	private int usuarioID;
	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String nombreUsuario;
	private String contrasena;
	
	@Override
	public String toString() {
		return "USUARIOS [UsuarioID=" + usuarioID + ", nombre=" + nombre + ", apellidoMaterno=" + apellidoMaterno
				+ ", apellidoPaterno=" + apellidoPaterno + ", Usuario=" + nombreUsuario + ", contrasena=" + contrasena + "]";
	}
	
	public Usuario() {
		
	}
	
	public Usuario(int usuarioID, String nombre, String apellidoMaterno, String apellidoPaterno, String nombreUsuario, String contrasena){
		this.usuarioID = usuarioID;
		this.nombre = nombre;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
