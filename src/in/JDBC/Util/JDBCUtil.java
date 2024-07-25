package in.JDBC.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;

public class JDBCUtil {
	
	
	// task to load the properties from the application file and loading the driver with connection.
	public static Connection getJdbcConnection() throws IOException, SQLException {
		FileInputStream FIS=new FileInputStream("Application.Properties");
		Properties P=new Properties();
		P.load(FIS);
		
		String url=P.getProperty("url");
		String user=P.getProperty("user");
		String password=P.getProperty("password");
		
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		Connection connection=DriverManager.getConnection(url, user, password);
		 return connection;
		
	}
	public static void closeResource(Connection connection,PreparedStatement preparedstatement,ResultSet resultset) throws SQLException {
		if(connection!=null) {
			connection.close();
		}if(preparedstatement!=null) {
			preparedstatement.close();
		}if(resultset!=null) {
			resultset.close();
		}
	}
	public static void closeResource(Connection connection, PreparedStatement preparedstatement) throws SQLException {
		if(connection!=null) {
			connection.close();
		}if(preparedstatement!=null) {
			preparedstatement.close();
		}
	}
	

}
