package controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.Connect;

public class UserController {
	
	private Connect db;
	
	public UserController() {
		this.db = Connect.getInstance();
	}

	public void login(String Username, String Password) {
		
		if(Username.length() > 0) {
			// code check to database
		}
		
		if(Password.length() > 0) {
			// code check to database
		}
		
	}
	
	public boolean register(String Username, String Password, String Phone_Number, String Address, String Role) {
		
		boolean validate = checkAccountValidation(Username, Password, Phone_Number, Address);
		if(validate == true) {
			// code insert data to database
			String query = "INSERT INTO users(username, password, phone, address, role) VALUES(?, ?, ?, ?, ?)";
			
			try (PreparedStatement pst = db.prepareStatement(query)){
				
				pst.setString(1, Username);
				pst.setString(2, Password);
				pst.setString(3, Phone_Number);
				pst.setString(4, Address);
				pst.setString(5, Role);
				pst.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			System.out.println("Insert OK");
			return true;
		}else {
			return false;
		}
		
	}
	
	private boolean checkAccountValidation(String Username, String Password, String Phone_Number, String Address) {
		
		boolean status = false;
		
		if(Username.length() >= 3){
			// masukin code buat cek apakah username yang diinput ada yang sama dengan yang udah
			// ada di database
			
			status = true;
		}
		
		if(Password.length() >= 8) {
			if(Password.contains("!") || Password.contains("@") || Password.contains("#") || Password.contains("$") || Password.contains("%") || Password.contains("^") || Password.contains("&") || Password.contains("*")) {
				status = true;
			}
		}
		
		if(Phone_Number.contains("+62")) {
			String check = Phone_Number.substring(1);
			if(check.length() >= 10 ) {
				status = true;
			}
		}
		
		if(Address.length() == 0) {
			return false;
		}
		
		return status;
	}
	
	
}
