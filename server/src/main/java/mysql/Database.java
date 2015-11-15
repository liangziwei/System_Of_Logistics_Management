package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private static Connection conn=null;
	private static Statement stat;
	private static ResultSet rs;
	
	static{
		try {
			
			conn=DatabaseConnect.getConnection();
			stat=conn.createStatement();
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet query(String table,String idname,String id){
		String sql="SELECT * FROM "+table+" WHERE "+idname+"="+"'"+id+"'";
		try {
			rs=stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static boolean update(String sql){
		int x;
		try {
			x=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean add(String table,String val){
		int x;
		String sql="INSERT INTO "+table+" VALUES("+val+")";
		try {
			x=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean delete(String table,String idname,String id){
		int x;
		String sql="DELETE FROM "+table+" WHERE "+idname+"="+"'"+id+"'";
		try {
			x=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean modify(String table,String val,String idname,String id){
		int x;
		String sql="UPDATE "+table+" SET "+val+" WHERE "+idname+"="+"'"+id+"'";;
		try {
			x=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
