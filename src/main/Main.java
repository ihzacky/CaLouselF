package main;

import java.util.ArrayList;

import controllers.MainController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.RegView;

public class Main extends Application implements EventHandler<ActionEvent> {
	
	ArrayList<Scene> appScenes = null;

	public Main() {
		
	}

	public void init() {
		appScenes = new ArrayList<Scene>();
		appScenes.add(RegView.createRegView());
		new MainController();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		init();
		primaryStage.setTitle("CaLouselF");
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
