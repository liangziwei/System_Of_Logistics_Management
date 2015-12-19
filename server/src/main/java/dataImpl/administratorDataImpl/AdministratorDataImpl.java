package dataImpl.administratorDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import constant.Authority;
import constant.UserType;
import mysql.Database;
import po.administratorPO.AdministratorPO;
import dataService.administratorDataService.AdministratorDataService;

public class AdministratorDataImpl implements AdministratorDataService {

	ResultSet rs;
	
	public boolean addUser(AdministratorPO administratorPO) {
		// TODO Auto-generated method stub
		UserType type = administratorPO.getType();
		String name = administratorPO.getName();
		String id=administratorPO.getId();
		String password = administratorPO.getPassword();
		Authority limit = administratorPO.getLimit();
		int limit1=0;
		if(limit==Authority.高){
			limit1=1;
		}
		String val="";
		val="'"+id+"','"+password+"','"+name+"',"+limit1+",'"+type.toString()+"'";
		
		return Database.add("administrator", val);
	}

	public boolean deleteUser(String administratorid) {
		// TODO Auto-generated method stub
		
		return Database.delete("administrator", "id", administratorid);
	}

	public boolean modifyUser(AdministratorPO administratorPO) {
		// TODO Auto-generated method stub
		UserType type = administratorPO.getType();
		String name = administratorPO.getName();
		String id=administratorPO.getId();
		String password = administratorPO.getPassword();
		Authority limit = administratorPO.getLimit();
		int limit1=0;
		if(limit==Authority.高){
			limit1=1;
		}
		String val="";
		val="password='"+password+"',name='"+name+"',limit1="+limit1+",type='"+type.toString()+"'";
		
		return Database.modify("administrator", val, "id", id);
	}

	public AdministratorPO findUser(String administratorid) {
		// TODO Auto-generated method stub
		UserType type = null;
		String name = null;
		String id=administratorid;
		String password = null;
		Authority limit = Authority.高;
		try {
			rs=Database.query("administrator", "id", administratorid);
			while(rs.next()){
			  type=UserType.valueOf(rs.getString("type"));
			  name=rs.getString("name");
			  password=rs.getString("password");
			  int limit1=(rs.getInt("limit1"));
			  if(limit1==0){
				  limit = Authority.低; 
			  }
			}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AdministratorPO(type,name,id,password,limit);
	}

	public String getPassword(String userid) {
		// TODO Auto-generated method stub
		String password="";
		try {
			rs=Database.query("administrator", "id", userid);
			while(rs.next()){
			  password=rs.getString("password");
			}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

}
