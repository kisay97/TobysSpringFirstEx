package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false", "root", "root");
		
		return conn;
	}

}
