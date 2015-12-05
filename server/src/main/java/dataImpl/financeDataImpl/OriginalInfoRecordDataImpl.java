package dataImpl.financeDataImpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import mysql.Database;
import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryPO;
import dataService.financeDataService.OriginalInfoDataService;
import dataService.financeDataService.OriginalInfoRecordDataService;

public class OriginalInfoRecordDataImpl implements OriginalInfoRecordDataService {

	@Override
	public List<StaffPO> getStaffInfo(int year) throws RemoteException {
		// TODO Auto-generated method stub
		List<StaffPO> thelist = new ArrayList<StaffPO>();
		String staffid = null;
		String name = null;
		String position = null;
		String gender = null;
		String birthday = null;
		String salary = null;
		String sql = "SELECT * FROM staffRecord WHERE year="+year;
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
			return null;
		}
		return thelist;
	}

	@Override
	public List<OrganizationPO> getOrganizationInfo(int year)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> thelist = new ArrayList<OrganizationPO>();
		String id = null;
		String type = null;
		String name = null;
		String sql = "SELECT * FROM organizationRecord WHERE year="+year;
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
			return null;
		}
		return thelist;

	}

	@Override
	public List<VehiclePO> getVehicleInfo(int year) throws RemoteException {
		// TODO Auto-generated method stub
		List<VehiclePO> thelist = new ArrayList<VehiclePO>();
		String vehicleid = null;
		String number = null;
		String age = null;
		String sql = "SELECT * FROM vehicleRecord WHERE year="+year;
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
			return null;
		}
		return thelist;
	}

	@Override
	public List<RepositoryPO> getRepositoryInfo(int year)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<RepositoryPO> thelist = new ArrayList<RepositoryPO>();
		String deliveryid = null;
		String inrepositorydate = null;
		String arrivalid = null;
		AreaCodeType areaCode = null;
		String rowid = null;
		String shelfid = null;
		String posid = null;
		String sql = "SELECT * FROM repositoryRecord WHERE year="+year;
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
			return null;
		}
		
		return thelist;
	}

	@Override
	public List<AccountPO> getAccountInfo(int year) throws RemoteException {
		// TODO Auto-generated method stub
		List<AccountPO> thelist = new ArrayList<AccountPO>();
		String name = null;
		double balance = 0.0;
		String sql = "SELECT * FROM accountRecord WHERE year="+year;
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
			return null;
		}
		return thelist;
	}

	@Override
	public boolean addStaffInfo(int year, List<StaffPO> list)
			throws RemoteException {
		// TODO Auto-generated method stub
		String sql;
		String staff_id;
		for(StaffPO staffPO:list){
			sql = "insert into staffRecord values(";
			staff_id = staffPO.getId();
			sql += year+",'"+staff_id.substring(0, 6) + "','" + staff_id + "','" + staffPO.getName() + "','" 
					+ staffPO.getPosition() + "','"+ staffPO.getGender() + "','" 
					+ staffPO.getBirthday() + "','"+ staffPO.getSalary() + "','" + staffPO.getSalaryType() + "',1,1);";
			try {
				Database.operate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean addOrganizationInfo(int year, List<OrganizationPO> list)
			throws RemoteException {
		// TODO Auto-generated method stub
		String sql;
		for(OrganizationPO organizationPO:list){
			sql = "insert into organizationRecord values(";
			sql +=year+",'"+ organizationPO.getId() + "','" + organizationPO.getType() 
					+ "','" + organizationPO.getName() + "','" + organizationPO.isApproved()
					+ "','" + organizationPO.isPassed() + "');";
			try {
				Database.operate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addVehicleInfo(int year, List<VehiclePO> list)
			throws RemoteException {
		// TODO Auto-generated method stub
		String vehicleid;
		String number;
		String age;
		String sql;
		for(VehiclePO vehiclePO:list){
			vehicleid=vehiclePO.getVehicleid();
			number=vehiclePO.getNumber();
			age=vehiclePO.getAge();
			sql=year+"'"+vehicleid+"','"+number+"','"+age+"'";
			if(!Database.add("vehicleRecord", sql)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addRepositoryInfo(int year, List<RepositoryPO> list)
			throws RemoteException {
		// TODO Auto-generated method stub
		String deliveryid ;
		String inrepositorydate ;
		String arrivalid ;
		AreaCodeType areaCode;
		String rowid;
		String shelfid ;
		String posid ;
		String val;
		for(RepositoryPO repositoryPO:list){
			deliveryid = repositoryPO.getdeliveryid();
			inrepositorydate = repositoryPO.getinrepositorydate();
			arrivalid = repositoryPO.getarrivalid();
			areaCode = repositoryPO.getareaCode();
			rowid = repositoryPO.getrowid();
			shelfid = repositoryPO.getshelfid();
			posid = repositoryPO.getposid();

			val = "'" + deliveryid + "','" + inrepositorydate + "','" + arrivalid + "','" + areaCode.toString() + "','"
					+ rowid + "','" + shelfid + "','" + posid + "'";
			try {
				if(!Database.add("repositoryRecord", val)){
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAccountInfo(int year, List<AccountPO> list)
			throws RemoteException {
		// TODO Auto-generated method stub
		String name;
		double balance;
		String val;
		for(AccountPO accountPO:list){
			name = accountPO.getName();
			balance = accountPO.getBalance();
			val = "'"+name+"',"+balance;
			
			if(!Database.add("accountRecord", val)){
				return false;
			}
		}
		
		return true;
	}

	@Override
	public List<Integer> getYearList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
