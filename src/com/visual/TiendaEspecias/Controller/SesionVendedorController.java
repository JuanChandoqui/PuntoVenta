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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SesionVendedorController implements Initializable {

    @FXML
    private ImageView imagenAvatar;

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private PasswordField textFieldContrasena;

    @FXML
    private Button botonSalir;

    @FXML
    private Button botonIniciarSesion;

    @FXML
    private Button botonCambiarSesion;
    
    @FXML
    private Label labelErrorUsuario;

    @FXML
    private Label labelErrorContrasena;

    @FXML
    void botonIniciarSesionOnMouseClicked(MouseEvent event) throws IOException {
    	UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getUsuario(textFieldUsuario.getText());
		    
		    	if(usuario != null) {
		    		if(usuario.getContrasena().equals(textFieldContrasena.getText())) 
		    			Main.setFXML("MenuVendedor", "Especias - Condimentos");
		    		else
		    			labelErrorContrasena.setText("Contrasena incorrecta");
		    	}
		    	else
		    		labelErrorUsuario.setText("Usuario no existente");
    }
    
    @FXML
    void botonCambiarSesionOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("Root", "Bienvenido");
    }

    @FXML
    void botonSalirOnMouseClicked(MouseEvent event) {
    	System.exit(0);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//anadir imagen
		imagenAvatar.setImage(new Image("Resources/logoTienda.png"));
		
	}
}
