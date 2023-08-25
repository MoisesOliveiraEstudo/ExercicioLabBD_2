package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection connect() throws ClassNotFoundException, SQLException {
	
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		return DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/ex_views_union");
	}

	
}
