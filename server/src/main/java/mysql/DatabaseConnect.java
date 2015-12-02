package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseConnect {

	private static final String URL="jdbc:mysql://localhost/logistics_system";
	private static final String USER="root";
//	private static final String PASSWORD="blabla";
	private static final String PASSWORD="r4anwe5we5123456";

	private static Connection conn=null;
	
	private static void connection() {
		  try {			  
			  Class.forName("com.mysql.jdbc.Driver");   

		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		  
		  try {
			  conn = DriverManager.getConnection(URL,USER,PASSWORD);
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	}
	public static Connection getConnection(){
		if(conn == null){
			connection();
		}
		return conn;
	}
	public static void disconnect(){
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
