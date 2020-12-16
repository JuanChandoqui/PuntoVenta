package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;
import com.visual.TiendaEspecias.DAO.UsuarioDAO;
import com.visual.TiendaEspecias.Entitys.Usuario;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModificarUsuarioController implements Initializable{

    @FXML
    private TextField txt_UsuarioID;

    @FXML
    private TextField txt_NombreUsuario;

    @FXML
    private TextField txt_Contrasena;

    @FXML
    private TextField txt_Nombre;

    @FXML
    private TextField txt_ApellidoP;

    @FXML
    private TextField txt_ApellidoM;

    @FXML
    private Button botonModificar;

    @FXML
    private Button botonCancelar;
    
    @FXML
	private Label lblErrorID;
    
    private UsuarioDAO usuarioDAO;
    private Usuario actualizarUsuario;

    @FXML
    void botonCancelarOnMouseClicked(MouseEvent event) {
    	Main.getSecondStage().close();	
    }

    @FXML
    void botonModificarOnMouseClicked(MouseEvent event) throws IOException {   	
    	int usuarioID = Integer.parseInt(txt_UsuarioID.getText());
    	String nombre = txt_Nombre.getText();
    	String apellidoM = txt_ApellidoM.getText();
    	String apellidoP = txt_ApellidoP.getText();
    	String usuario = txt_NombreUsuario.getText();
    	String contrasena = txt_Contrasena.getText();
    	actualizarUsuario = new Usuario(usuarioID, nombre, apellidoM, apellidoP, usuario, contrasena);
    	if(usuarioDAO.update(actualizarUsuario)) {	
	    	Main.getSecondStage().close();
	    	Main.setFXML("TablaUsuarios", "Usuarios");
    	}
    	else
    		for (int i = 0; i < usuarioDAO.getAllUsuario().size(); i++) {
    			if(usuarioDAO.getAllUsuario().get(i).getUsuarioID()!= usuarioID) 
        			lblErrorID.setText("Usuario ID invalido");   		
			}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usuarioDAO = new UsuarioDAO();
		
	}

}
