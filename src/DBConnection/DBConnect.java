package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private String url ="jdbc:mysql://localhost:3306/qlchdt";
	private String user ="root";
	private String pwd = "1234";
	
	public Connection getConnection() {
		Connection cnn = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			cnn = DriverManager.getConnection(url,user,pwd);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return cnn;
	}
}