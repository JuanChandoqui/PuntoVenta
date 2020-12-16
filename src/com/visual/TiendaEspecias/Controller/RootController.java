package com.visual.TiendaEspecias.Controller;

import java.io.IOException;

import com.visual.TiendaEspecias.Main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RootController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button botonAdministrador;

    @FXML
    private Button botonPersonalVenta;

    @FXML
    private Button botonSalir;

    @FXML
    void administradorOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("SesionAdmi", "Iniciar Sesi�n");
    }

    @FXML
    void botonPersonalVentaOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("SesionVendedor", "Iniciar Sesi�n");
    }

    @FXML
    void botonSalirOnMouseClicked(MouseEvent event) {
    	System.exit(0);
    }
}

