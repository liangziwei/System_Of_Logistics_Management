package dataImpl.financeDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryPO;
import dataService.financeDataService.OriginalInfoDataService;
import mysql.Database;

public class OriginalInfoDataImpl implements OriginalInfoDataService{
	
	ResultSet rs;
	@Override
	public List<StaffPO> getStaffInfo(int year) {
		// TODO Auto-generated method stub
		List<StaffPO> thelist = new ArrayList<StaffPO>();
		String staffid = null;
		String name = null;
		String position = null;
		String gender = null;
		String birthday = null;
		String salary = null;
		String sql = "SELECT * FROM staff";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			while(rs.next()){
				staffid = rs.getString("id");
				name = rs.getString("name");
				position = rs.getString("position");
				gender = rs.getString("gender");
				birthday = rs.getString("birthday");
				salary = rs.getString("salary");
				StaffPO staffPO = new StaffPO(name, staffid, position, gender, birthday, salary, null, false, true);
				thelist.add(staffPO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return thelist;
	}
	@Override
	public List<OrganizationPO> getOrganizationInfo(int year) {
		// TODO Auto-generated method stub
		List<OrganizationPO> thelist = new ArrayList<OrganizationPO>();
		String id = null;
		String type = null;
		String name = null;
		String sql = "SELECT * FROM organization";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			while(rs.next()){
				id = rs.getString("id");
				type = rs.getString("type");
				name = rs.getString("name");
				OrganizationPO organizationPO = new OrganizationPO(type, id, name, false, true);
				thelist.add(organizationPO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return thelist;
	}
	@Override
	public List<VehiclePO> getVehicleInfo(int year) {
		// TODO Auto-generated method stub
		List<VehiclePO> thelist = new ArrayList<VehiclePO>();
		String vehicleid = null;
		String number = null;
		String age = null;
		String sql = "SELECT * FROM vehicle";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			while(rs.next()){
				vehicleid = rs.getString("vehicleid");
				number = rs.getString("number");
				age = rs.getString("age");
				VehiclePO vehiclePO = new VehiclePO(vehicleid, number, age);
				thelist.add(vehiclePO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return thelist;
	}
	@Override
	public List<RepositoryPO> getRepositoryInfo(int year) {
		// TODO Auto-generated method stub
		List<RepositoryPO> thelist = new ArrayList<RepositoryPO>();
		String deliveryid = null;
		String inrepositorydate = null;
		String arrivalid = null;
		AreaCodeType areaCode = null;
		String rowid = null;
		String shelfid = null;
		String posid = null;
		String sql = "SELECT * FROM repository";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			while(rs.next()){
				deliveryid = rs.getString("deliveryid");
				inrepositorydate = rs.getString("inrepositorydate");
				arrivalid = rs.getString("arrivalid");
				areaCode = AreaCodeType.valueOf(rs.getString("areaCode"));
				rowid = rs.getString("rowid");
				shelfid = rs.getString("shelfid");
				posid = rs.getString("posid");
				RepositoryPO repositoryPO = new RepositoryPO(deliveryid, inrepositorydate, arrivalid, areaCode, rowid, shelfid, posid);
				thelist.add(repositoryPO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return thelist;
	}
	@Override
	public List<AccountPO> getAccountInfo(int year) {
		// TODO Auto-generated method stub
		List<AccountPO> thelist = new ArrayList<AccountPO>();
		String name = null;
		double balance = 0.0;
		String sql = "SELECT * FROM account";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			while(rs.next()){
				name = rs.getString("name");
				balance = rs.getDouble("balance");
				AccountPO accountPO = new AccountPO(name, balance);
				thelist.add(accountPO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return thelist;
	}

}
