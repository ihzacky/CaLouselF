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
	private String itemId;
	private String itemName;
	private String itemSize;
	private String itemPrice;
	private String itemCategory;
	private String itemStatus;
	private String itemWishlist;
	private String itemOfferStatus;
	private String userId;

	public Item(String item_name, String item_size, String item_price, String item_category, String user_id) {
		itemId = genId();
		itemName = item_name;
		itemSize = item_size;
		itemPrice = item_price;
		itemCategory = item_category;
		itemStatus = "pending";
		itemWishlist = "none";
		itemOfferStatus = "none";
		this.userId = user_id;
	}
	
	public Item(String item_id, String item_name, String item_size, String item_price, String item_category,
			String item_status, String item_wishlist, String item_offer_status, String user_id) {
		super();
		itemId = item_id;
		itemName = item_name;
		itemSize = item_size;
		itemPrice = item_price;
		itemCategory = item_category;
		itemStatus = item_status;
		itemWishlist = item_wishlist;
		itemOfferStatus = item_offer_status;
		this.userId = user_id;
	}

	private String genId() {
		Random rn = new Random();
		return "IT" + Integer.toString(rn.nextInt(10)) + Integer.toString(rn.nextInt(10)) + Integer.toString(rn.nextInt(10));
	}
	
	public boolean UploadItem(String item_name, String item_category, String item_size, String item_price, String user_id) {
		
		String query = "INSERT INTO items (Item_id, Item_name, Item_size, Item_price, "
				+ "Item_category, Item_status, Item_wishlist, Item_offer_status, user_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		final Connect con = Connect.getInstance();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, this.itemId);
			pst.setString(2, this.itemName);
			pst.setString(3, this.itemSize);
			pst.setString(4, this.itemPrice);
			pst.setString(5, this.itemCategory);
			pst.setString(6, this.itemStatus);
			pst.setString(7, this.itemWishlist);
			pst.setString(8, this.itemOfferStatus);
			pst.setString(9, this.userId);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static List<Item> selectAll(String col, String req) {
		List<Item> itemList = new ArrayList<>();
		String query = "SELECT * FROM items";
		
		if((col != null) && (req != null)) {
			query = query + " WHERE " + col + " = " + "?"; 
		}
		
		final Connect con = Connect.getInstance();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			
			if((col != null) && (req != null)) {
				pst.setString(1, req); 
			}
			
			ResultSet rs = pst.executeQuery(); 
			
			while(rs.next()) {
				itemList.add(new Item(rs.getString("Item_id"), rs.getString("Item_name"), rs.getString("Item_size"), 
						rs.getString("Item_price"), rs.getString("Item_category"), rs.getString("Item_status"), 
						rs.getString("Item_wishlist"), rs.getString("Item_offer_status"), rs.getString("user_id")));
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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemWishlist() {
		return itemWishlist;
	}

	public void setItemWishlist(String itemWishlist) {
		this.itemWishlist = itemWishlist;
	}

	public String getItemOfferStatus() {
		return itemOfferStatus;
	}

	public void setItemOfferStatus(String itemOfferStatus) {
		this.itemOfferStatus = itemOfferStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
