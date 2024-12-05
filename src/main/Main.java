package main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import viewFactories.viewFactory;

public class Main extends Application implements EventHandler<ActionEvent> {
	
	ArrayList<Scene> appScenes = null;

	public Main() {
		
	}

	public void init() {
		appScenes = new ArrayList<Scene>();
		appScenes.add(viewFactory.createRegView());
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("Registrant Manager");
		primaryStage.setScene(appScenes.get(0));
		primaryStage.show();
	}
	
	public Stage getPrimaryStage() {
		return getPrimaryStage();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
