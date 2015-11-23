package dataImpl.managerDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.Database;
import po.managerPO.StaffPO;
import dataService.managerDataService.StaffManagementDataService;

/**
 * description:数据服务层为人员管理提供服务的具体实现
 * @author 张仁知
 */
public class StaffManagementDataImpl implements StaffManagementDataService{
	
	ResultSet rs;

	public boolean addStaff(StaffPO staffPO) {
		String id = staffPO.getId();
		String name = staffPO.getName();
		String position = staffPO.getPosition();
		String gender = staffPO.getGender();
		String birthday = staffPO.getBirthday();
		String salary = staffPO.getSalary();
		String val = "";
		val = "'"+id+"','"+name+"','"+position+"','"+gender+"','"+birthday+"','"+salary+"'";
		return Database.add("staff", val);
	}
	
	public StaffPO findStaff(String id) {
		String Id = id;
		String name = null;
		String position = null;
		String gender = null;
		String birthday = null;
		String salary = null;
		try{
			rs= Database.query("staff", "id", id);
			while(rs.next()){
				name = rs.getString("name");
				position = rs.getString("position");
				gender = rs.getString("gender");
				birthday = rs.getString("birthday");
				salary = rs.getString("salary");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return new StaffPO(name,Id,position,gender,birthday,salary);
	}
	
	public boolean deleteStaff(String id) {
		return Database.delete("staff","id", id);
	}
	
	public boolean modifyStaff(StaffPO staffPO) {
		String id = staffPO.getId();
		String name = staffPO.getName();
		String position = staffPO.getPosition();
		String gender = staffPO.getGender();
		String birthday = staffPO.getBirthday();
		String salary = staffPO.getSalary();
		String val ="";
		val = "name='"+name+"',position='"+position+"',gender='"+gender+"',birthday='"+birthday+"',salary='"+salary+"'";
		return Database.modify("staff", val, "id", id);
	}
}
