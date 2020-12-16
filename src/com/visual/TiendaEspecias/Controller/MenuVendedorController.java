package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MenuVendedorController implements Initializable{

    @FXML
    private ImageView imagenLogo;

    @FXML
    private Button botonListaProductos;

    @FXML
    private Button botonCambiarSesion;

    @FXML
    private Button botonSalir;
    
    @FXML
    private Label fecha;
    

    @FXML
    void botonCambiarSesionOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("Root", "Bienvenido");
    }

    @FXML
    void botonListaProductosOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("TablaProducto", "Productos");
    }

    @FXML
    void botonSalirOnMouseClicked(MouseEvent event) {
    	System.exit(0);
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imagenLogo.setImage(new Image("Resources/logoTienda.png"));	
	}
}
