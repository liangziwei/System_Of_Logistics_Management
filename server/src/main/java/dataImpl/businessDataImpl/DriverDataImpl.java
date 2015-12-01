package dataImpl.businessDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.Database;
import po.businessPO.DriverPO;
import dataService.businessDataService.DriverDataService;

public class DriverDataImpl implements DriverDataService {

	ResultSet rs;
	public boolean addDriver(DriverPO driverPO) {
		// TODO Auto-generated method stub
		String driveridStr=driverPO.getDriverid();
		String nameStr=driverPO.getName();
		String birthdayStr=driverPO.getBirthday();
		String idNumber=driverPO.getIdNumber();
		String phoneStr=driverPO.getPhoneNumber();
		String genderStr=driverPO.getGender();
		String drivingDeadlineStr=driverPO.getDrivingDeadline();
		
		String var;
		var="'"+driveridStr+"','"+nameStr+"','"+birthdayStr+"','"+idNumber+"','"+phoneStr+"','"+genderStr+"','"+drivingDeadlineStr+"'";
		return Database.add("driver", var);
	}

	public DriverPO findDriver(String driverid) {
		// TODO Auto-generated method stub
		DriverPO driverPO;
		String driveridStr=driverid;
		String nameStr=null;
		String birthdayStr=null;
		String idNumber=null;
		String phoneStr=null;
		String genderStr=null;
		String drivingDeadlineStr=null;
		try {
			rs=Database.query("driver", "driverid", driverid);
			while(rs.next()){
				nameStr=rs.getString("name");
				birthdayStr=rs.getString("birthday");
				idNumber=rs.getString("idNumber");
				phoneStr=rs.getString("phone");
				genderStr=rs.getString("gender");
				drivingDeadlineStr=rs.getString("drivingDeadline");
			}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driverPO=new DriverPO(driveridStr,nameStr,birthdayStr,idNumber,phoneStr,genderStr,drivingDeadlineStr);
			driverPO.setWrong(true);
			return driverPO;
		}
		driverPO=new DriverPO(driveridStr,nameStr,birthdayStr,idNumber,phoneStr,genderStr,drivingDeadlineStr);
		return driverPO;
	}

	public boolean deleteDriver(String driverid) {
		// TODO Auto-generated method stub
		return Database.delete("driver", "driverid", driverid);
	}

	public boolean modifyDriver(DriverPO driverPO) {
		// TODO Auto-generated method stub
		
		String driverid=driverPO.getDriverid();
		String nameStr=driverPO.getName();
		String birthdayStr=driverPO.getBirthday();
		String idNumber=driverPO.getIdNumber();
		String phoneStr=driverPO.getPhoneNumber();
		String genderStr=driverPO.getGender();
		String drivingDeadlineStr=driverPO.getDrivingDeadline();
		
		String var;
		var="name='"+nameStr+"',birthday='"+birthdayStr+"',idNumber='"+idNumber+"',phoneNumber='"+phoneStr+"',gender'"+genderStr+"',drivingDeadline'"+drivingDeadlineStr+"'";
		return Database.modify("driver", var, "driverid", driverid);

	}

}
