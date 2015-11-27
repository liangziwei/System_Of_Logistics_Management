package dataImpl.managerDataImpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataService.managerDataService.OrganizationManagementDataService;
import mysql.Database;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;

/**
 * description:数据服务层为机构管理提供服务的具体实现
 * @author 张仁知
 */
public class OrganizationManagementDataImpl implements OrganizationManagementDataService{

	
	ResultSet rs;
	
	public boolean addOrganization(OrganizationPO organizationPO) {
		String sql = "insert into organization values('";
		sql += organizationPO.getId() + "','" + organizationPO.getType() 
				+ "','" + organizationPO.getName() + "','" + organizationPO.isApproved()
				+ "','" + organizationPO.isPassed() + "');";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public OrganizationPO findOrganization(String id) {
		String type = null;
		String Id = id;
		String name = null;
		boolean isApproved = false;
		boolean isPassed = false;
		try{
			rs = Database.query("organization", "id", id);
			if(rs.next()){
				type = rs.getString("type");
				name = rs.getString("name");
				isApproved = Boolean.parseBoolean(rs.getString("is_approved"));
				isPassed = Boolean.parseBoolean(rs.getString("is_passed"));
			}
			else return null;
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return new OrganizationPO(type, Id, name, isApproved, isPassed);
	}
	
	public boolean deleteOrganization(String id) {
		return Database.delete("organization", "id", id);
	}
	
	public boolean modifyOrganization(OrganizationPO organizationPO) {
		this.deleteOrganization(organizationPO.getId());
		return this.addOrganization(organizationPO);
	}

	public List<StaffPO> findStaffInfos(String organizationId) throws RemoteException {
		List<StaffPO> staffs = new ArrayList<StaffPO>();
		String sql = "select * from staff where organization_id = '" + organizationId + "';";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				StaffPO temp = new StaffPO(rs.getString("name"), rs.getString("staff_id"), rs.getString("position"),
						rs.getString("gender"), rs.getString("birthday"), rs.getString("salary"),
						rs.getString("salary_type"), Boolean.parseBoolean(rs.getString("is_approved")),
						Boolean.parseBoolean(rs.getString("is_passed")));
				staffs.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return staffs;
	}

	public boolean deleteStaffsByOrgId(String organizationId) throws RemoteException {
		String sql = "delete from staff where organization_id = '" + organizationId + "';";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
