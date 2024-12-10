package controllers;

import java.util.List;

import Models.Item;

public class ItemController {
	
	public boolean InputData(String item_name, String item_category, String item_size, String item_price) {
		if(CheckItemValidation(item_name, item_category, item_size, item_price)) {
			return false;
		}
		else {
			Item newItem = new Item(item_name, item_category, item_size, item_price);
			newItem.UploadItem(item_name, item_category, item_size, item_price);
		}
		
		return true;
	}
	
	public void viewItem() {
		List<Item> itemList = Item.selectAll();
		
		//Logic to display to view
	}
	
	public boolean CheckItemValidation(String item_name, String item_category, String item_size, String item_price) {
		
		if((item_name == "") || (item_name.length() < 3)) {
			return true;
		}
		
		if((item_category == "") || (item_category.length() < 3)) {
			return true;
		}
		
		if(item_size == "") {
			return true;
		}
		
		if((item_price == "") || (item_price == "0") || (containDigit(item_price))) {
			return true;
		}
		
		return false;
	}
	
	private boolean containDigit(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!(Character.isDigit(s.charAt(i)))) {
				return true;
			}
		}
		
		return false;
	}
	
}
