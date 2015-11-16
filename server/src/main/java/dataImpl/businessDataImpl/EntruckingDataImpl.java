package dataImpl.businessDataImpl;

import mysql.Database;
import po.businessPO.EntruckingPO;
import dataService.businessDataService.EntruckingDataService;

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

}
