package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	private static String HOST = "localhost:3306";
	private static String DATABASE = "Calouself";
	private static String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
	
	private static Connect database;
	Connection con;
	
	public static Connect getInstance() {
		if(database == null) {
			database = new Connect();
		}
		
		return database;
	}
	
	private Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			System.out.println("DB Connected!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pst;
	}
	
	
	
}
