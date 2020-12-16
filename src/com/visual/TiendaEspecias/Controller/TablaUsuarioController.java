package com.visual.TiendaEspecias.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.TiendaEspecias.Main;
import com.visual.TiendaEspecias.DAO.UsuarioDAO;
import com.visual.TiendaEspecias.Entitys.Usuario;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TablaUsuarioController implements Initializable{

    @FXML
    private TableView<Usuario> tableroUsuario;

    @FXML
    private TableColumn<Usuario, Integer> usuarioID;

    @FXML
    private TableColumn<Usuario, String> nombre;

    @FXML
    private TableColumn<Usuario, String> apellidoM;

    @FXML
    private TableColumn<Usuario, String> apellidoP;

    @FXML
    private TableColumn<Usuario, String> nombreUsuario;

    @FXML
    private TableColumn<Usuario, String> contrasena;

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonModificar;

    @FXML
    private Button botonEliminar;

    @FXML
    private ImageView imagenLogo;
    
    @FXML
    private ImageView imagenFondo;

    @FXML
    private Button botonVolver;
    
    private UsuarioDAO listaUsuarios;
    
    @FXML
    void botonAgregarOnMouseClicked(MouseEvent event) {
    	Main.SubStage("AgregarUsuario", "Agregar Nuevo Usuario");
    }

    @FXML
    void botonEliminarOnMouseClicked(MouseEvent event) {
    	Main.SubStage("EliminarUsuario", "Eliminar Usuario");
    }

    @FXML
    void botonModificarOnMouseClicked(MouseEvent event) {
    	Main.SubStage("ModificarUsuario", "Modificar Usuario");
    }

    @FXML
    void botonVolverOnMouseClicked(MouseEvent event) throws IOException {
    	Main.setFXML("MenuAdministrador", "Especias - Condimentos");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imagenLogo.setImage(new Image("Resources/logoTienda.png"));
		imagenFondo.setImage(new Image("Resources/fondoTabla.png"));
		
		listaUsuarios = new UsuarioDAO();
		
		//Llenar datos en la tablaView
		usuarioID.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("UsuarioID"));
		nombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Nombre"));
		apellidoM.setCellValueFactory(new PropertyValueFactory<Usuario, String>("ApellidoMaterno"));
		apellidoP.setCellValueFactory(new PropertyValueFactory<Usuario, String>("ApellidoPaterno"));
		nombreUsuario.setCellValueFactory(new PropertyValueFactory<Usuario, String>("NombreUsuario"));
		contrasena.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Contrasena"));
		
		tableroUsuario.setItems(listaUsuarios.getAllUsuario());
	}

}
