package com.visual.TiendaEspecias;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Scene scene;
	private static Stage stage;
	private static Stage secondStage;
		
	public static Stage getSecondStage() {
		return secondStage;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			scene = new Scene(loadFXML("Root"));
			scene.setFill(Color.TRANSPARENT);
			stage = primaryStage;
			stage.setScene(scene);
			stage.setResizable(false);
			stage.sizeToScene();
			stage.centerOnScreen();
			stage.setTitle("Bienvenido");
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.getIcons().add(new Image("Resources/logoTienda.png"));
			stage.show();
			
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setFXML(String fxml, String tittle) throws IOException{
		scene.setRoot(loadFXML(fxml));
		stage.sizeToScene();
		stage.centerOnScreen();
		stage.setTitle(tittle);
	}
	
	private static Parent loadFXML(String fxml)throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/" + fxml + ".fxml"));	
		return fxmlLoader.load();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static void SubStage(String fxml, String tittle){
		try {
			Parent node = loadFXML(fxml);
			secondStage = new Stage();
			Scene scene = new Scene(node);
			secondStage.setScene(scene);
			secondStage.setTitle(tittle);
			secondStage.initOwner(stage);
			secondStage.initModality(Modality.WINDOW_MODAL);
			secondStage.centerOnScreen();
			secondStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
