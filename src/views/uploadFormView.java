package views;

import Models.User;
import controllers.ItemController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class uploadFormView extends VBox {

	TextField nameTf;
	Label nameLabel;
	Label catLabel;
	TextField sizeNumberTf;
	Label sizeLabel;
	TextField priceTf;
	TextField sizeTf;
	TextField catTf;
	Label priceLabel;
	Button uploadBtn;
	Button backBtn;
	HBox btnWrapper;
	Label errorLbl;
	
	Stage stage;
	User user;
	
	public uploadFormView(Stage stage, User user) {
		this.stage = stage;
		this.user = user;
		init();
		stage.setScene(new Scene(this, 400, 600));
		stage.setTitle("Form");
		stage.show();
	}

	private void init() {
		nameTf = new TextField();
		nameLabel = new Label("Name");
		nameLabel.setLabelFor(nameTf);
		
		catTf = new TextField();
		catLabel = new Label("Category");
		catLabel.setLabelFor(catTf);
		
		sizeTf = new TextField();
		sizeLabel = new Label("Size");
		sizeLabel.setLabelFor(sizeTf);
		
		priceTf = new TextField();
		priceLabel = new Label("Price");
		priceLabel.setLabelFor(priceTf);
		
		uploadBtn = new Button("Upload");
		backBtn = new Button("Back");
		errorLbl = new Label("");
		
		btnWrapper = new HBox(backBtn);
		btnWrapper.getChildren().add(uploadBtn);
		
		uploadBtn.setOnAction(e -> {
			String name = nameTf.getText();
			String category = catTf.getText();
			String size = sizeTf.getText();
			String price = priceTf.getText();
			
			boolean cond = ItemController.InputData(name, category, size, price, user.getUser_Id());
			
			if(!cond) {
				errorLbl.setText("Invalid Credentials");
			}
			else {
				new SellerHomeView(stage, user);
			}
			
		});
		
		backBtn.setOnAction(e -> {
			new SellerHomeView(stage, user);
		});
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(nameLabel, nameTf, catLabel, catTf, sizeLabel, 
				sizeTf, priceLabel, priceTf, btnWrapper, errorLbl);
	}
	
}
