package dataImpl.businessDataImpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataService.businessDataService.EntruckingDataService;
import mysql.Database;
import po.businessPO.EntruckingPO;

public class EntruckingDataImpl implements EntruckingDataService {
	
	private String date;
	private String businessHallid;
	private String transportNumber;
	private String destionation;
	private String vehicleid;
	private String supervisor;//监装员
	private String supercargo;//押运员
	private double freight;//运费
	public boolean addEntruckingFrom(EntruckingPO entruckingPO) {
		// TODO Auto-generated method stub
		date=entruckingPO.getDate();
		businessHallid=entruckingPO.getBusinessHallid();
		transportNumber=entruckingPO.getTransportNumber();
		destionation=entruckingPO.getDestionation();
		vehicleid=entruckingPO.getVehicleid();
		supervisor=entruckingPO.getSupervisor();
		supercargo=entruckingPO.getSupercargo();
		freight=entruckingPO.getFreight();
		
		String val="";
		val="'"+date+"','"+businessHallid+"','"+transportNumber+"','"+destionation+"','"+vehicleid+"','"+supervisor+"','"+supercargo+"',"+freight+",0,1";
		
		return Database.add("entrucking", val);
	}
	
	public ArrayList<EntruckingPO> getUncheckEntrucking() {
		ArrayList<EntruckingPO> po = new ArrayList<EntruckingPO>();
		String sql = "select * from entrucking where isApproved = 0;";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createEntruckingPO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	private EntruckingPO createEntruckingPO(ResultSet rs) {
		try {
			return new EntruckingPO(rs.getString("date"), rs.getString("businessHallid"), rs.getString("transportNumber"),
					rs.getString("destionation"), rs.getString("vehicleid"),
					rs.getString("supervisor"), rs.getString("supercargo"), rs.getDouble("freight"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean approveOneEntrucking(EntruckingPO form) throws RemoteException {
		String sql = "update entrucking set isApproved = 1, isPassed = 1 where "
				+ "transportNumber = '" + form.getTransportNumber() + "';";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean approveMoreEntrucking(ArrayList<EntruckingPO> form) throws RemoteException {
		int size = form.size();
		for(int i = 0; i < size; i++) {
			this.approveOneEntrucking(form.get(i));
		}
		return true;
	}
}
