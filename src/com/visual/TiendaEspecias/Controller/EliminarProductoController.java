package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;
import com.visual.TiendaEspecias.DAO.InventarioDAO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EliminarProductoController implements Initializable{

    @FXML
    private TextField txt_ProductoID;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label lblMensaje;
    
    private InventarioDAO inventarioDAO;

    @FXML
    void botonCancelarOnMouseClicked(MouseEvent event) {
    	Main.getSecondStage().close();
    }

    @FXML
    void botonEliminarOnMouseClicked(MouseEvent event) throws IOException { 	
        int id = Integer.parseInt(txt_ProductoID.getText());
        
        if(inventarioDAO.delete(id)) {
        	Main.getSecondStage().close();
        	Main.setFXML("TablaInventario", "Inventario");
        }
        else
        	lblMensaje.setText("ID invalida");
    
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inventarioDAO = new InventarioDAO();
		
	}

}
