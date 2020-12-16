package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;
import com.visual.TiendaEspecias.Adapter.MariaDBAdapter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class MenuAdministradorController implements Initializable{

    @FXML
    private ImageView imagenLogo;

    @FXML
    private Button botonListaUsuarios;

    @FXML
    private Button botonInventario;

    @FXML
    private Button botonReporte;

    @FXML
    private Button botonCambiarSesion;

    @FXML
    private Button botonSalir;
    
    @FXML
    private Label lblFecha;
    

    @FXML
    void botonCambiarSesionOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("Root", "Bienvenido");
    }

    @FXML
    void botonInventarioOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("TablaInventario", "Inventario");
    }


    @FXML
    void botonListaUsuariosOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("TablaUsuarios", "Tabla de Usuarios");
    }

    @FXML
    void botonReporteOnMouseClicked(MouseEvent event) {
    	MariaDBAdapter adapter = MariaDBAdapter.getInstancia();
    	
    	//CompraDAO adapterr = new CompraDAO();
    	JasperPrint jasperPrintWindow = null;
    	try {
			jasperPrintWindow = JasperFillManager.fillReport("Reportes/Compras.jasper", null, adapter.getConnection());
			JasperExportManager.exportReportToPdfFile(jasperPrintWindow, "Informes/Compras.pdf");
			JasperViewer.viewReport(jasperPrintWindow, false);
			
		} catch (JRException e) {
			e.printStackTrace();
		}
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
