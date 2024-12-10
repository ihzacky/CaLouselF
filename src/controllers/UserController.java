package controllers;

import Models.User;

public class UserController {

	public UserController() {
		
	}
	
	public void login(String Username, String Password) {
		if(User.getUser(Username) != null) {
			return;
		}
		
		if(checkAccountValidation(Username, Password, null, null)) {
			return;
		}
		
		//Switch view
	}
	
	public void register(String Username, String Password, String Phone_Number, String Address) {
		if(User.getUser(Username) != null) {
			return;
		}
		
		if(checkAccountValidation(Username, Password, Phone_Number, Address)) {
			return;
		}
		
		User newUser = new User(Username, Password, Address, Phone_Number, Address);
		newUser.insertUser();
	}
	
	public boolean checkAccountValidation(String Username, String Password, String Phone_Number, String Address) {
		
		boolean status = false;
		status = validateUsername(Username);
		status = validatePassword(Username);
		
		if((Phone_Number != null) && (Address != null)) {
			status = validateAddress(Address);
			status = validatePhoneNumber(Phone_Number);
		}
		
		return status;
	}

	private boolean validatePhoneNumber(String phone_Number) {
		String temp = phone_Number;
		temp.replace("+62", "+");
		
		if((temp.length() == 10) && (phone_Number.contains("+62"))) {
			return true;
		}
		
		return false;
	}

	private boolean validateAddress(String address) {
		if(address == "") {
			return true;
		}
		
		return false;
	}

	private boolean validatePassword(String username) {
		if((username == null) || (username.contains("!")) || (username.contains("@")) || (username.contains("#")) || (username.contains("$"))
				|| (username.contains("%")) || (username.contains("^")) || (username.contains("&")) || (username.contains("*"))) {
			return true;
		}
		
		return false;
	}

	private boolean validateUsername(String username) {
		if((username == null) || (username.length() < 3)) {
			return true;
		}
		
		return false;
	}
	
	private User requestUser(String username) {
		return User.getUser(username);
	}
}
