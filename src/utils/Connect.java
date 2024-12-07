package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Connect {
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	private static String HOST = "host:3306";
	private static String DATABASE = "Calouself";
	private static String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);

	public static ResultSet rs;
	private ResultSetMetaData rsm;
	private PreparedStatement ps;
	
	private static Connect conn;
	private Connection con;
	private Statement st;
	
	public static Connect getInstance() {
		if(conn == null) {
			conn = new Connect();
		}
		
		return conn;
	}
	
	private Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			st = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
