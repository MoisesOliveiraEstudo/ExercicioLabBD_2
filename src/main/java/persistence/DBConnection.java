package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection connect() throws ClassNotFoundException, SQLException {
		
		String host = "localhost";
		String db = "crud-db-01";
		String user = "user";
		String senha = "user-pass";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		return DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/crud_db_01");
	}

	
}
