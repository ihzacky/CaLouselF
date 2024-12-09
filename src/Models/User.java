package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.Connect;

public class User {

	private int user_Id;
	private String username;
	private String password;
	private String address;
	private String phone_number;
	private String role;

	public User(int user_Id, String username, String password, String address, String phone_number, String role) {
		this.user_Id = user_Id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone_number = phone_number;
		this.role = role;
	}
	
	public void insertUser() {
		String query = "INSERT INTO user (username, password, phone_number, roles) VALUES(?, ?, ?, ?);";
		final Connect con = Connect.getInstance();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, this.username);
			pst.setString(2, this.password);
			pst.setString(3, this.phone_number);
			pst.setString(4, this.role);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static User getUser(String username) {
		User user = null;
		String query = "SELECT user FROM Calouself WHERE username = ?";
		final Connect con = Connect.getInstance();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, "\"" + username + "\"");
			
			ResultSet rs = pst.executeQuery(query); 
			
			while(rs.next()) {
				user = new User(rs.getInt("user_Id"), rs.getString("username"), rs.getString("password"), 
						rs.getString("address"),rs.getString("phone_number"), rs.getString("role"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
