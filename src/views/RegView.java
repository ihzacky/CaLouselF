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

public class RegView extends VBox{
	
		Stage stage;
	
		Label titleLabel;
		Label regLabel;
		Button regBtn;
		Button logBtn;
		TextField nameTf;
		Label nameLabel;
		PasswordField passTf;
		Label passLabel;
		TextField phoneNumberTf;
		Label phoneLabel;
		TextField addressTf;
		Label addressLabel;
		ToggleGroup rolesGroup;
		RadioButton roleB;
		RadioButton roleS;
		Label errorLbl;
		GridPane gs;
	
		private void init() {
			this.setAlignment(Pos.CENTER);
			
			titleLabel = new Label("CaLouselF");
	        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	        titleLabel.setStyle("-fx-padding: 30 0 10 0;");
	        
	        regLabel = new Label("Register");
	        regLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
	        regLabel.setStyle("-fx-padding: 0 0 20 0;");
			
			regBtn = new Button("Register");
			logBtn = new Button("Login");
			
			nameTf = new TextField();
			nameLabel = new Label("Name");
			nameLabel.setLabelFor(nameTf);
			
			passTf = new PasswordField();
			passLabel = new Label("Password");
			passLabel.setLabelFor(passTf);
			
			phoneNumberTf = new TextField();
			phoneLabel = new Label("Phone Number");
			phoneLabel.setLabelFor(phoneNumberTf);
			
			addressTf = new TextField();
			addressLabel = new Label("Adress");
			addressLabel.setLabelFor(addressTf);
			
			rolesGroup = new ToggleGroup();
			roleB = new RadioButton("Buyer");
			roleB.setToggleGroup(rolesGroup);
			roleS = new RadioButton("Seller");
			roleS.setToggleGroup(rolesGroup);
			
			errorLbl = new Label("");
			
			regBtn.setOnAction(e -> {
				String name = nameTf.getText();
				String pass = passTf.getText();
				String pNumber = phoneNumberTf.getText();
				String adress = addressTf.getText();
				String role = null;
				
				if(roleB.isSelected()) {
					role = roleB.getText();
				}
				
				if(roleS.isSelected()) {
					role = roleS.getText();
				}
				
				User user = UserController.register(name, pass, pNumber, adress, role);
				
				if(user == null) {
					errorLbl.setText("Invalid Credentials");
				}
				else {
					new SellerHomeView(stage, user); 
				}
			});
			
			logBtn.setOnAction(e -> {
				new LogView(stage);
			});
			
			gs = new GridPane();
			gs.add(nameLabel, 0, 0);
			gs.add(nameTf, 0, 1);
			gs.add(passLabel, 0, 2);
			gs.add(passTf, 0, 3);
			gs.add(phoneLabel, 0, 4);
			gs.add(phoneNumberTf, 0, 5);
			gs.add(addressLabel, 0, 6);
			gs.add(addressTf, 0, 7);
			
			gs.add(roleB, 0, 8);
			gs.add(roleS, 1, 8);
			gs.add(regBtn, 0, 9);
			gs.add(logBtn, 1, 9);
			gs.add(errorLbl, 0, 10);
			
			gs.setAlignment(Pos.CENTER);
			this.getChildren().add(titleLabel);
			this.getChildren().add(regLabel);
			this.getChildren().add(gs);
	}
		
	public RegView(Stage stage) {
		this.stage = stage;
		init();
		stage.setScene(new Scene(this, 400, 600));
		stage.setTitle("Register");
		stage.show();
	}

}
