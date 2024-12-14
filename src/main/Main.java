package main;

import java.util.ArrayList;

import controllers.MainController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.RegView;

public class Main extends Application {

	public Main() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new RegView(primaryStage);
	}

}
