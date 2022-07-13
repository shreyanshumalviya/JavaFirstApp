package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "hr";
	private static final String PASSWORD = "hr";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		if (getConnection() != null) {
			System.out.println("Connected");
		} else {
			System.out.println("NOT Connected");
		}

	}

}
