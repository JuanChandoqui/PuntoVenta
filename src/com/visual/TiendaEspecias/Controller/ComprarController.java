package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;
import com.visual.TiendaEspecias.DAO.CompraDAO;
import com.visual.TiendaEspecias.DAO.InventarioDAO;
import com.visual.TiendaEspecias.DAO.ProductoDAO;
import com.visual.TiendaEspecias.Entitys.TotalCompras;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

public class ComprarController implements Initializable{

    @FXML
    private TextField txt_ProductoID;

    @FXML
    private TextField txt_Kilogramos;

    @FXML
    private Button botonComprar;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label lblErrorID;

    @FXML
    private Label lblErrorCantidad;
    
    private ProductoDAO productoDAO;
    private CompraDAO compraDAO;
    private InventarioDAO inventarioDAO;
    private TotalCompras compra;
 
    @FXML
    void botonComprarOnMouseClicked(MouseEvent event) throws IOException {	
    	compra = new TotalCompras();
    	boolean encontrado = false;
    	int indice = 0;  	
    	
    	int id = Integer.parseInt(txt_ProductoID.getText());
    	double kg = Double.valueOf(txt_Kilogramos.getText());
    	
    	for (int i = 0; i < productoDAO.getAllProducto().size(); i++) {
			if(productoDAO.getAllProducto().get(i).getProductoID() == id) {
				encontrado = true;
				indice = i;
			}
		}
    	
    	if(encontrado) {
    		double total = productoDAO.getAllProducto().get(indice).getPrecio() * kg;
    		compra.calcularTotalDia(total);
    		
    		int productoID = productoDAO.getAllProducto().get(indice).getProductoID();
    		String nombre = productoDAO.getAllProducto().get(indice).getNombre();
    		double precio = productoDAO.getAllProducto().get(indice).getPrecio();	
    		double stockActualizado = inventarioDAO.getAllProducto().get(indice).getStock() - kg;	
    		
    		inventarioDAO.updateStock(productoID, stockActualizado);
    		
    		compra(productoID, nombre, precio, kg, compra.getTotalDia(), indice);  		
        	Main.getSecondStage().close();
        	Main.setFXML("TablaProducto", "Usuarios");
        	DialogoCompraExitosa();
    	}
    	else
    		lblErrorID.setText("ID invalido");
    		

    }

    @FXML
    void botonCancelarOnMouseClicked(MouseEvent event) {
    	Main.getSecondStage().close();
    }
    
    //Al momento de realizar compras y obtener los totales para generar el reporte
    public void compra(int productoID, String nombre, double precio, double kg, double total, int indice) {
    	int compraID = compraDAO.getAllCompras().size()+1;
    	productoID = productoDAO.getAllProducto().get(indice).getProductoID();
    	nombre = productoDAO.getAllProducto().get(indice).getNombre();
    	
    	compra = new TotalCompras(compraID, productoID, nombre, precio, kg, total); 	
    	compraDAO.insert(compra);
    }

    public void DialogoCompraExitosa() {
    	Alert dialogo = new Alert(AlertType.INFORMATION);
    	dialogo.setTitle("Informacion de compra");
    	dialogo.setHeaderText(null);
    	dialogo.setContentText("Compra exitosa");
    	dialogo.initStyle(StageStyle.UTILITY);
    	dialogo.showAndWait();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		productoDAO = new ProductoDAO();
		compraDAO = new CompraDAO();
		inventarioDAO = new InventarioDAO();
	}

}
