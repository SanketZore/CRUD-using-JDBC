package CRUDOP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import in.JDBC.Util.JDBCUtil;
public class SelectQuery {
	
	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		ResultSet result=null;
		Scanner sc=new Scanner(System.in);
		try {
			connection=JDBCUtil.getJdbcConnection();
			
			if(connection!=null) {
				String mysqlQuery="select * from student where id=?";
				
				preparedstatement=connection.prepareStatement(mysqlQuery);
				
				if(preparedstatement!=null) {
					System.out.print("Enter the Id which you want to get from MySql: ");
					int id=sc.nextInt();
					preparedstatement.setInt(1, id);
					
					result=preparedstatement.executeQuery();
					if(result!=null) {
						if(result.next()) {
							System.out.println("ID\tNAME\tROLLNUM\tRESULT");
							System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getInt(3)+"\t"+result.getString(4));
						}
					}		
					
				}
			}
			
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.closeResource(connection, preparedstatement,result);
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


}
