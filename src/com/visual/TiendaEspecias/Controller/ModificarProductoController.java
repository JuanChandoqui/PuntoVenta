package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;
import com.visual.TiendaEspecias.DAO.InventarioDAO;
import com.visual.TiendaEspecias.Entitys.Producto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModificarProductoController implements Initializable{

    @FXML
    private TextField txt_ProductoID;

    @FXML
    private TextField txt_Nombre;

    @FXML
    private TextField txt_Precio;

    @FXML
    private TextField txt_Tipo;

    @FXML
    private TextField txt_Stock;

    @FXML
    private Button botonModificar;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label lblErrorID;

    private InventarioDAO inventarioDAO;
    private Producto actualizarProducto;
    
    @FXML
    void botonCancelarOnMouseClicked(MouseEvent event) {
    	Main.getSecondStage().close();
    }

    @FXML
    void botonModificarOnMouseClicked(MouseEvent event) throws IOException {  	
       	int productoID = Integer.parseInt(txt_ProductoID.getText());
    	String nombre = txt_Nombre.getText();
    	double precio = Double.valueOf(txt_Precio.getText());
    	String tipo = txt_Tipo.getText();
    	double stock = Double.valueOf(txt_Stock.getText());
    	actualizarProducto = new Producto(productoID, nombre, precio, tipo, stock);
    	
    	if(inventarioDAO.update(actualizarProducto)) {	
	    	Main.getSecondStage().close();
	    	Main.setFXML("TablaInventario", "Inventario");
    	}
    	else
    		for (int i = 0; i < inventarioDAO.getAllProducto().size(); i++) {
    			if(inventarioDAO.getAllProducto().get(i).getProductoID() != productoID) 
        			lblErrorID.setText("Producto ID invalido");   		
			}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inventarioDAO = new InventarioDAO();
	}

}
