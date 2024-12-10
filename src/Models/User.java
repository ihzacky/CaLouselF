package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import utils.Connect;

public class User {

	private String user_Id;
	private String username;
	private String password;
	private String address;
	private String phone_number;
	private String role;

	public User(String username, String password, String address, String phone_number, String role) {
		this.user_Id = genId();
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone_number = phone_number;
		this.role = role;
	}
	
	private String genId() {
		Random rn = new Random();
		return "US" + Integer.toString(rn.nextInt(10)) + Integer.toString(rn.nextInt(10)) + Integer.toString(rn.nextInt(10));
	}

	public void insertUser() {
		String query = "INSERT INTO users (username, password, phone_number, roles) VALUES(?, ?, ?, ?);";
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
		String query = "SELECT users FROM Calouself WHERE username = ?";
		final Connect con = Connect.getInstance();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, "\"" + username + "\"");
			
			ResultSet rs = pst.executeQuery(query); 
			
			while(rs.next()) {
				user = new User(rs.getString("username"), rs.getString("password"), 
						rs.getString("address"),rs.getString("phone_number"), rs.getString("role"));
				user.setUser_Id(rs.getString("user_Id"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
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
