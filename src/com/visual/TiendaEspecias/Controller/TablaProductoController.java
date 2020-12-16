package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;
import com.visual.TiendaEspecias.DAO.ProductoDAO;
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

public class TablaProductoController implements Initializable{
    
    @FXML
    private TableView<Producto> tableroProducto;

    @FXML
    private TableColumn<Producto, Integer> productoID;

    @FXML
    private TableColumn<Producto, String> nombre;

    @FXML
    private TableColumn<Producto, Double> precio;

    @FXML
    private TableColumn<Producto, Double> cantidad;

    @FXML
    private TableColumn<Producto, String> tipo;

    @FXML
    private ImageView imagenLogo;
    
    @FXML
    private ImageView imagenFondo;

    @FXML
    private Button botonVolver;
    
    @FXML
    private Button botonComprar;
    
    private ProductoDAO listaProductos;
    
    @FXML
    void botonComprarOnMouseClicked(MouseEvent event) {
    	Main.SubStage("Comprar", "Adquirir Producto");
    }

    @FXML
    void botonVolverOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("MenuVendedor", "Especias - Condimentos");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imagenLogo.setImage(new Image("Resources/logoTienda.png"));
		imagenFondo.setImage(new Image("Resources/fondoTabla.png"));
		
		listaProductos = new ProductoDAO();
		
		//Llenar datos en la tablaView
		productoID.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("ProductoID"));
		nombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("Nombre"));
		precio.setCellValueFactory(new PropertyValueFactory<Producto, Double>("Precio"));
		cantidad.setCellValueFactory(new PropertyValueFactory<Producto, Double>("Cantidad"));
		tipo.setCellValueFactory(new PropertyValueFactory<Producto, String>("Tipo"));
		
		tableroProducto.setItems(listaProductos.getAllProducto());
	}

}
