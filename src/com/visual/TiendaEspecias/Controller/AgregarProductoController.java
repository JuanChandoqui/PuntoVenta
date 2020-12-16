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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgregarProductoController implements Initializable{

    @FXML
    private TextField txt_Nombre;

    @FXML
    private TextField txt_Precio;

    @FXML
    private TextField txt_Tipo;

    @FXML
    private TextField txt_Stock;

    @FXML
    private Button botonAnadir;

    @FXML
    private Button botonCancelar;
    
    private InventarioDAO inventarioDAO;

    @FXML
    void botonAnadirOnMouseClicked(MouseEvent event) throws IOException {
    	Producto producto;
    	
    	int productoID = (inventarioDAO.getAllProducto().get(inventarioDAO.getAllProducto().size() - 1).getProductoID()) + 1;
    	String nombre = txt_Nombre.getText();
    	Double precio = Double.valueOf(txt_Precio.getText());
    	String tipo = txt_Tipo.getText();
    	Double stock = Double.valueOf(txt_Stock.getText());
    	
    	producto = new Producto(productoID, nombre, precio, tipo, stock);
    	inventarioDAO.insert(producto);
    	
    	Main.getSecondStage().close();
    	Main.setFXML("TablaInventario", "Inventario");
    }

    @FXML
    void botonCancelarOnMouseClicked(MouseEvent event) {
    	Main.getSecondStage().close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inventarioDAO = new InventarioDAO();	
	}

}
