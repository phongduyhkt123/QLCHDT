package BLL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private String url ="jdbc:mysql://localhost:3306/qlchdt";
	private String user ="root";
	private String pwd = "123456";
	
	public Connection getConnection() {
		Connection cnn = null;
		try {
			/*Class.forName("com.mysql.jdbc.Driver");*/
			cnn = DriverManager.getConnection(url,user,pwd);
			System.out.print("aaaaaa");
		}catch(Exception ex)
		{
			System.out.println("Failed!");
			System.out.println("ERROR:" +ex.getMessage());
		}
		return cnn;
	}
	public static void main(String[] args) {
		DBConnect db = new DBConnect();
		db.getConnection();
	}

}