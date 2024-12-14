package views;

import Models.Item;
import Models.User;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class HomeComponent extends VBox {
	TableColumn<Item, String> nameCol;
	TableColumn<Item, String> categoryCol;
	TableColumn<Item, String> sizeCol;
	Label mainNameLabel;
	Label roleLabel;
	TableView<Item> table;
	User user;
	Stage stage;
	HBox mainWrapper;
	HBox roleWrapper;
	ObservableList<Item> obs;

	public abstract void setTableItems();
	
	public HomeComponent(User user, Stage stage) {
		this.user = user;
		this.stage = stage;
		init();
	}
	
	private void init() {
		categoryCol = new TableColumn("category");
		categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
		
		nameCol = new TableColumn("name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		sizeCol = new TableColumn("size");
		sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
		
		table = new TableView<Item>();
		table.getColumns().addAll(categoryCol, nameCol, sizeCol);
		setTableItems();
		
		mainNameLabel = new Label(user.getUsername());
		mainNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        mainNameLabel.setStyle("-fx-padding: 30 0 10 0;");
        
        roleLabel = new Label(user.getRole());
        roleWrapper = new HBox(roleLabel);
        roleWrapper.setAlignment(Pos.CENTER);
        
        mainWrapper = new HBox(mainNameLabel);
        mainWrapper.setAlignment(Pos.CENTER);
		
		this.getChildren().add(mainWrapper);
		this.getChildren().add(roleWrapper);
		this.getChildren().add(table);
		
	}
}
