package controllers;

import Models.User;

public class UserController {

	public UserController() {
		
	}
	
	public static User login(String Username, String Password) {
		User user = User.getUser(Username);
		
		if(user == null) {
			return null;
		}
		
		if((!user.getPassword().equals(Password)) || (!user.getUsername().equals(Username))) {
			return null;
		}
		
		return user;
	}
	
	public static User register(String Username, String Password, String Phone_Number, String Address, String Role) {
		User newUser = null; 
		
		if(User.getUser(Username) != null) {
			return null;
		}
		
		if(checkAccountValidation(Username, Password, Phone_Number, Address)) {
			return null;
		}
		
		newUser = new User(Username, Password, Phone_Number, Address, Role);
		newUser.insertUser();
		return newUser;
	}
	
	public static boolean checkAccountValidation(String Username, String Password, String Phone_Number, String Address) {
		
		boolean status = false;
		status = validateUsername(Username);
		status = validatePassword(Password);
		
		if((Phone_Number != null) && (Address != null)) {
			status = validateAddress(Address);
			status = validatePhoneNumber(Phone_Number);
		}
		
		return status;
	}

	private static boolean validatePhoneNumber(String phone_Number) {
		String temp = phone_Number;
		temp = temp.replace("+62", "+");
		
		if((temp.length() == 10) && (phone_Number.contains("+62"))) {
			return false;
		}
		
		return true;
	}

	private static boolean validateAddress(String address) {
		if(address == "") {
			return true;
		}
		
		return false;
	}

	private static boolean validatePassword(String username) {
		if((username.length() >= 8) && ((username.contains("!")) || (username.contains("@")) || (username.contains("#")) || (username.contains("$"))
				|| (username.contains("%")) || (username.contains("^")) || (username.contains("&")) || (username.contains("*")))) {
			return false;
		}
		
		return true;
	}

	private static boolean validateUsername(String username) {
		if((username == "") || (username.length() < 3)) {
			return true;
		}
		
		return false;
	}
	
	private User requestUser(String username) {
		return User.getUser(username);
	}
}
