package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/crud_struts1?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";
	private static String USER_NAME = "root";
	private static String PASSWORD = "1234";

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Connection getConnection(String dbURL, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}
