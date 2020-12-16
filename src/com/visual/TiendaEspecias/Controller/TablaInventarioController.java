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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TablaInventarioController implements Initializable {

    @FXML
    private TableView<Producto> tableroInventario;

    @FXML
    private TableColumn<Producto, Integer> productoID;

    @FXML
    private TableColumn<Producto, String> nombre;

    @FXML
    private TableColumn<Producto, Double> precio;
    
    @FXML
    private TableColumn<Producto, String> tipo;

    @FXML
    private TableColumn<Producto, Double> stock;

    @FXML
    private ImageView imagenLogo;

    @FXML
    private ImageView imagenFondo;

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonModificar;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonVolver;    
    
    private InventarioDAO inventarioDAO;

    @FXML
    void botonAgregarOnMouseClicked(MouseEvent event) {
    	Main.SubStage("AgregarProducto", "Agregar Nuevo Producto");
    }

    @FXML
    void botonEliminarOnMouseClicked(MouseEvent event) {
    	Main.SubStage("EliminarProducto", "Eliminar Producto");
    }

    @FXML
    void botonModificarOnMouseClicked(MouseEvent event) {
    	Main.SubStage("ModificarProducto", "Modificar Producto");
    }

    @FXML
    void botonVolverOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("MenuAdministrador", "Especias - Condimentos");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imagenLogo.setImage(new Image("Resources/logoTienda.png"));
		imagenFondo.setImage(new Image("Resources/fondoTabla.png"));
		
		inventarioDAO = new InventarioDAO();
		
		//Llenar datos en la tablaView
		productoID.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("ProductoID"));
		nombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("Nombre"));
		precio.setCellValueFactory(new PropertyValueFactory<Producto, Double>("Precio"));
		tipo.setCellValueFactory(new PropertyValueFactory<Producto, String>("Tipo"));
		stock.setCellValueFactory(new PropertyValueFactory<Producto, Double>("Stock"));
		
		tableroInventario.setItems(inventarioDAO.getAllProducto());
	}

}
