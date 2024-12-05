package Models;

public class User {

	private String user_Id;
	private String username;
	private String password;
	private String address;
	private String phone_number;
	private String role;

	public User(String user_Id, String username, String password, String address, String phone_number, String role) {
		this.user_Id = user_Id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone_number = phone_number;
		this.role = role;
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
