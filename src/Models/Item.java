package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.Connect;

public class Item {
	private String Item_id;
	private String Item_name;
	private String Item_size;
	private String Item_price;
	private String Item_category;
	private String Item_status;
	private String Item_wishlist;
	private String Item_offer_status;
	
	public Item(String item_name, String item_size, String item_price, String item_category) {
		Item_id = genId();
		Item_name = item_name;
		Item_size = item_size;
		Item_price = item_price;
		Item_category = item_category;
		Item_status = "pending";
		Item_wishlist = "none";
		Item_offer_status = "none";
	}
	
	public Item(String item_id, String item_name, String item_size, String item_price, String item_category,
			String item_status, String item_wishlist, String item_offer_status) {
		super();
		Item_id = item_id;
		Item_name = item_name;
		Item_size = item_size;
		Item_price = item_price;
		Item_category = item_category;
		Item_status = item_status;
		Item_wishlist = item_wishlist;
		Item_offer_status = item_offer_status;
	}

	private String genId() {
		Random rn = new Random();
		return "IT" + Integer.toString(rn.nextInt(10)) + Integer.toString(rn.nextInt(10)) + Integer.toString(rn.nextInt(10));
	}
	
	public boolean UploadItem(String item_name, String item_category, String item_size, String item_price) {
		
		String query = "INSERT INTO items (Item_id, Item_name, Item_size, Item_price, "
				+ "Item_category, Item_status, Item_wishlist, Item_offer_status) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
		final Connect con = Connect.getInstance();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, this.Item_id);
			pst.setString(2, this.Item_name);
			pst.setString(3, this.Item_size);
			pst.setString(4, this.Item_price);
			pst.setString(5, this.Item_category);
			pst.setString(6, this.Item_status);
			pst.setString(7, this.Item_wishlist);
			pst.setString(8, this.Item_offer_status);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static List<Item> selectAll() {
		List<Item> itemList = new ArrayList<Item>();
		String query = "SELECT * FROM items";
		final Connect con = Connect.getInstance();
		
		try {
			Statement st = con.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query); 
			
			while(rs.next()) {
				itemList.add(new Item(rs.getString("Item_id"), rs.getString("Item_name"), rs.getString("Item_size"), 
						rs.getString("Item_price"), rs.getString("Item_category"), rs.getString("Item_status"), 
						rs.getString("Item_wishlist"), rs.getString("Item_offer_status")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return itemList;
	}
	
	public boolean DeleteItem(String item_id) {
		final Connect conn = Connect.getInstance();
		String query = String.format("DELETE FROM registrants WHERE id is = %s", item_id);
		Statement st;
		
		try {
			st = conn.getConnection().createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public String getItem_id() {
		return Item_id;
	}
	public void setItem_id(String item_id) {
		Item_id = item_id;
	}
	public String getItem_name() {
		return Item_name;
	}
	public void setItem_name(String item_name) {
		Item_name = item_name;
	}
	public String getItem_size() {
		return Item_size;
	}
	public void setItem_size(String item_size) {
		Item_size = item_size;
	}
	public String getItem_price() {
		return Item_price;
	}
	public void setItem_price(String item_price) {
		Item_price = item_price;
	}
	public String getItem_category() {
		return Item_category;
	}
	public void setItem_category(String item_category) {
		Item_category = item_category;
	}
	public String getItem_status() {
		return Item_status;
	}
	public void setItem_status(String item_status) {
		Item_status = item_status;
	}
	public String getItem_wishlist() {
		return Item_wishlist;
	}
	public void setItem_wishlist(String item_wishlist) {
		Item_wishlist = item_wishlist;
	}
	public String getItem_offer_status() {
		return Item_offer_status;
	}
	public void setItem_offer_status(String item_offer_status) {
		Item_offer_status = item_offer_status;
	}
	
}
