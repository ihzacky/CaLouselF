package controllers;

import java.util.List;

import Models.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemController {
	
	public static boolean InputData(String item_name, String item_category, String item_size, String item_price, String user_id) {
		boolean cond = true;
		
		if(CheckItemValidation(item_name, item_category, item_size, item_price)) {
			return false;
		}
		else {
			Item newItem = new Item(item_name, item_size, item_price, item_category, user_id);
			cond = newItem.UploadItem(item_name, item_category, item_size, item_price, user_id);
		}
		
		return cond;
	}
	
	public static ObservableList<Item> viewItem(String col, String req) {
		List<Item> itemList = Item.selectAll(col, req);
		ObservableList<Item> obs = FXCollections.observableArrayList(itemList);
		return obs;
		
		//Error Arraylistnya ke to array?
	}
	
	public static boolean CheckItemValidation(String item_name, String item_category, String item_size, String item_price) {
		
		if((item_name == "") || (item_name.length() < 3)) {
			return true;
		}
		
		if((item_category == "") || (item_category.length() < 3)) {
			return true;
		}
		
		if(item_size == "") {
			return true;
		}
		
		if((item_price == "") || (item_price == "0") || (containAlpha(item_price))) {
			return true;
		}
		
		return false;
	}
	
	private static boolean containAlpha(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!(Character.isDigit(s.charAt(i)))) {
				return true;
			}
		}
		
		return false;
	}
	
}
