package dataImpl.managerDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataService.managerDataService.StaffManagementDataService;
import mysql.Database;
import po.managerPO.StaffPO;

/**
 * description:数据服务层为人员管理提供服务的具体实现
 * @author 张仁知
 */
public class StaffManagementDataImpl implements StaffManagementDataService{
	
	ResultSet rs;

	public boolean addStaff(StaffPO staffPO) {
		String sql = "insert into staff values('";
		String staff_id = staffPO.getId();
		sql += staff_id.substring(0, 6) + "','" + staff_id + "','" + staffPO.getName() + "','" 
				+ staffPO.getPosition() + "','"+ staffPO.getGender() + "','" 
				+ staffPO.getBirthday() + "','"+ staffPO.getSalary() + "','" + staffPO.getSalaryType() + "','"
				+ staffPO.isApproved() + "','" + staffPO.isPassed() + "');";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public StaffPO findStaff(String id) {
		String sql = "select * from staff where staff_id = '" + id + "';";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		String name = null;
		String position = null;
		String gender = null;
		String birthday = null;
		String salary = null;
		String type = null;
		boolean isApproved = false;
		boolean isPassed = false;
		try {
			while(rs.next()) {
				name = rs.getString("name");
				position = rs.getString("position");
				gender = rs.getString("gender");
				birthday = rs.getString("birthday");
				salary = rs.getString("salary");
				type = rs.getString("salary_type");
				isApproved = Boolean.parseBoolean(rs.getString("is_approved"));
				isPassed = Boolean.parseBoolean(rs.getString("is_passed"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		//如果在数据库中查找不到该人员信息
		if(name == null) return null;
		return new StaffPO(name, id, position, gender, birthday, salary, type,
				isApproved, isPassed);
	}
	
	public boolean deleteStaff(String id) {
		return Database.delete("staff","staff_id", id);
	}
	
	public boolean modifyStaff(StaffPO staffPO) {
		this.deleteStaff(staffPO.getId());
	    return this.addStaff(staffPO);
	}
}
