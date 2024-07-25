package CRUDOP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import in.JDBC.Util.JDBCUtil;

public class InsertMySqlQuery {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		try {
			connection=JDBCUtil.getJdbcConnection();
			
			if(connection!=null) {
				String mysqlQuery="insert into student(name,rollnum,result)values(?,?,?)";
				preparedstatement=connection.prepareStatement(mysqlQuery);
				if(preparedstatement!=null) {
					
					preparedstatement.setString(1,"Ram");
					preparedstatement.setInt(2, 20);
					preparedstatement.setString(3,"pass");
					
					int roweffected=preparedstatement.executeUpdate();
					if(roweffected==1) {
						System.out.println("Row Inserted");
					}else {
						System.out.println("Row Not Inserted");						
					}
				}
			}
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.closeResource(connection, preparedstatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}








