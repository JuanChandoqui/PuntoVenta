package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;
import com.visual.TiendaEspecias.DAO.UsuarioDAO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EliminarUsuarioController implements Initializable {

    @FXML
    private TextField txt_NombreUsuario;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label lblMensaje;
    
    private UsuarioDAO usuarioDAO;

    @FXML
    void botonEliminarOnMouseClicked(MouseEvent event) throws IOException {
    	int id = Integer.parseInt(txt_NombreUsuario.getText());
    
    	if(usuarioDAO.delete(id)) {
    		Main.getSecondStage().close();
    		Main.setFXML("TablaUsuarios", "Usuarios");
    	}
    	else
    		lblMensaje.setText("ID invalida");
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
