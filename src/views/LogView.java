package views;

import Models.User;
import controllers.UserController;
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

public class LogView extends VBox{
	
		Stage stage;
	
		Label titleLabel;
		Label regLabel;
		Button logBtn;
		TextField nameTf;
		Label nameLabel;
		PasswordField passTf;
		Label passLabel;
		Label errorLbl;
		GridPane gs;
	
		private void init() {
			this.setAlignment(Pos.CENTER);
			
			titleLabel = new Label("CaLouselF");
	        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	        titleLabel.setStyle("-fx-padding: 30 0 10 0;");
	        
	        regLabel = new Label("Login");
	        regLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
	        regLabel.setStyle("-fx-padding: 0 0 20 0;");
			
			logBtn = new Button("Login");
			
			nameTf = new TextField();
			nameLabel = new Label("Name");
			nameLabel.setLabelFor(nameTf);
			
			passTf = new PasswordField();
			passLabel = new Label("Password");
			passLabel.setLabelFor(passTf);
			
			errorLbl = new Label("");
			
			logBtn.setOnAction(e -> {
				String name = nameTf.getText();
				String pass = passTf.getText();
				
				User user = UserController.login(name, pass);
				
				if(user == null) {
					errorLbl.setText("Invalid Credentials");
				}
				else {
					new SellerHomeView(stage, user); 
				}
			});
			
			gs = new GridPane();
			gs.add(nameLabel, 0, 0);
			gs.add(nameTf, 0, 1);
			gs.add(passLabel, 0, 2);
			gs.add(passTf, 0, 3);
			gs.add(logBtn, 1, 9);
			gs.add(errorLbl, 0, 10);
			
			gs.setAlignment(Pos.CENTER);
			this.getChildren().add(titleLabel);
			this.getChildren().add(regLabel);
			this.getChildren().add(gs);
	}
		
	public LogView(Stage stage) {
		this.stage = stage;
		init();
		stage.setScene(new Scene(this, 400, 600));
		stage.setTitle("Login");
		stage.show();
	}

}
