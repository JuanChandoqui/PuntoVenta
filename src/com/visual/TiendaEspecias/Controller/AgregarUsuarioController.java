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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgregarUsuarioController implements Initializable{

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
    private Button botonAnadir;

    @FXML
    private Button botonCancelar;
    
    private UsuarioDAO usuarioDAO;
    private Usuario nuevoUsuario;
    
    @FXML
    void botonAnadirOnMouseClicked(MouseEvent event) throws IOException {   
		int usuarioID = (usuarioDAO.getAllUsuario().get(usuarioDAO.getAllUsuario().size() - 1).getUsuarioID()) + 1;
    	String nombre = String.valueOf(txt_Nombre.getText());
    	String apellidoM = txt_ApellidoM.getText();
    	String apellidoP = txt_ApellidoP.getText();
    	String usuario = txt_NombreUsuario.getText();
    	String contrasena = txt_Contrasena.getText();
    	nuevoUsuario = new Usuario(usuarioID, nombre, apellidoM, apellidoP, usuario, contrasena);
    	usuarioDAO.insert(nuevoUsuario);
    	Main.getSecondStage().close();
    	Main.setFXML("TablaUsuarios", "Usuarios");
    }

    @FXML
    void botonCancelarOnMouseClicked(MouseEvent event) {
    	Main.getSecondStage().close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usuarioDAO = new UsuarioDAO();
	}
    
    

}

