package dataImpl.managerDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysql.Database;
import po.managerPO.OrganizationPO;
import dataService.managerDataService.OrganizationManagementDataService;

/**
 * description:数据服务层为机构管理提供服务的具体实现
 * @author 张仁知
 */
public class OrganizationManagementDataImpl implements OrganizationManagementDataService{

	
	ResultSet rs;
	
	public boolean addOrganization(OrganizationPO organizationPO) {
		String type = organizationPO.getType();
		String id = organizationPO.getId();
		String name = organizationPO.getName();
		ArrayList<String> staffInfo = organizationPO.getStaffInfo();
		String val = "";
		val = "'"+id+"','"+type+"','"+name+"','";
		for(int i=0;i<staffInfo.size();i++){
			val += staffInfo.get(i)+"\n";
		}
		val+="'";
		return Database.add("organization", val);
	}
	
	public OrganizationPO findOrganization(String id) {
		String type = null;
		String Id = id;
		String name = null;
		String staffInfo = null;
		try{
			rs = Database.query("organization", "id", id);
			while(rs.next()){
				type = rs.getString("type");
				name = rs.getString("name");
				staffInfo = rs.getString("staffinfo");
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		String[] staffinfo = staffInfo.split("\n");
		ArrayList<String> staffId = new ArrayList<String>();
		for(int i=0;i<staffinfo.length;i++){
			staffId.add(staffinfo[i]);
		}
		return new OrganizationPO(type, Id, name, staffId);
	}
	
	public boolean deleteOrganization(String id) {
		return Database.delete("organization", "id", id);
	}
	
	public boolean modifyOrganization(OrganizationPO organizationPO) {
		String type = organizationPO.getType();
		String id = organizationPO.getId();
		String name = organizationPO.getName();
		ArrayList<String> staffInfo = organizationPO.getStaffInfo();
		String val ="";
		val = "type='"+type+"',name='"+name+"',staffinfo='";
		for(int i=0;i<staffInfo.size();i++){
			val+=staffInfo.get(i)+"\n";
		}
		val+="'";
		return Database.modify("organization", val, "id", id);
	}
}
