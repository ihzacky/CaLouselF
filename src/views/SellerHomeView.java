package views;

import Models.Item;
import Models.User;
import controllers.ItemController;
import controllers.UserController;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SellerHomeView extends HomeComponent {

	Button editItem;
	Button uploadItem;
	Button deleteBtn;
	HBox childWrapper;
	
	public SellerHomeView(Stage stage, User user) {
		super(user, stage);
		init();
		this.stage.setScene(new Scene(this, 400, 600));
		this.stage.setTitle("Home");
		this.stage.show();
	}
	
	private void init() {
		editItem = new Button("Edit");
		uploadItem = new Button("Upload");
		deleteBtn = new Button("Delete");
		
		uploadItem.setOnAction(e -> {
			new uploadFormView(this.stage, this.user);
		});
		
		childWrapper = new HBox(deleteBtn);
		childWrapper.getChildren().addAll(editItem, uploadItem);
		this.getChildren().add(childWrapper);
	}

	@Override
	public void setTableItems() {
		this.obs = ItemController.viewItem("Item_status", "approved");
	}
}
