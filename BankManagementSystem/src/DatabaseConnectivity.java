import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {
	private static final String URL = "jdbc:mysql://localhost:3306/BankingSystem";
	private static final String userName = "root";
	private static final String password = "Dasatva@9";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,userName,password);
		
	}
}
