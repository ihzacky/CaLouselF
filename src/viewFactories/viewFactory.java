package viewFactories;

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

public class viewFactory {

	public static Scene createRegView() {
		VBox v = new VBox();
		v.setAlignment(Pos.CENTER);
		
		Label titleLabel = new Label("CaLouselF");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setStyle("-fx-padding: 30 0 10 0;");
        
        Label regLabel = new Label("Register");
        regLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        regLabel.setStyle("-fx-padding: 0 0 20 0;");
		
		Button regBtn = new Button("Register");
		Button logBtn = new Button("Login");
		
		TextField nameTf = new TextField();
		Label nameLabel = new Label("Name");
		nameLabel.setLabelFor(nameTf);
		
		PasswordField passTf = new PasswordField();
		Label passLabel = new Label("Password");
		passLabel.setLabelFor(passTf);
		
		TextField phoneNumberTf = new TextField();
		Label phoneLabel = new Label("Phone Number");
		phoneLabel.setLabelFor(phoneNumberTf);
		
		TextField addressTf = new TextField();
		Label addressLabel = new Label("Adress");
		addressLabel.setLabelFor(addressTf);
		
		ToggleGroup rolesGroup = new ToggleGroup();
		RadioButton roleB = new RadioButton("Buyer");
		roleB.setToggleGroup(rolesGroup);
		RadioButton roleS = new RadioButton("Seller");
		roleS.setToggleGroup(rolesGroup);
		
		GridPane gs = new GridPane();
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
		
		gs.setAlignment(Pos.CENTER);
		
		v.getChildren().addAll(titleLabel, regLabel, gs);
		return new Scene(v, 800, 600);
	}

}
