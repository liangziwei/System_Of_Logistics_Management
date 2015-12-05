package dataImpl.businessDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import constant.Authority;
import constant.UserType;
import mysql.Database;
import po.businessPO.VehiclePO;
import dataService.businessDataService.VehicleDataService;

public class VehicleDataImpl implements VehicleDataService {

	ResultSet rs;
	public boolean addVehicle(VehiclePO vehiclePO) {
		// TODO Auto-generated method stub
		String vehicleid=vehiclePO.getVehicleid();
		String number=vehiclePO.getNumber();
		String age=vehiclePO.getAge();
		String var;
		var="'"+vehicleid+"','"+number+"','"+age+"'";
		return Database.add("vehicle", var);
	}

	public VehiclePO findVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		VehiclePO vehiclePO=new VehiclePO();
		String number = null;
		String age = null;
		try {
			rs=Database.query("vehicle", "vehicleid", vehicleid);
			while(rs.next()){
				number=rs.getString("number");
				age=rs.getString("age");
			}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vehiclePO.setWrong(true);
			return vehiclePO;
		}
		vehiclePO.setVehicleid(vehicleid);
		vehiclePO.setNumber(number);
		vehiclePO.setAge(age);
		return vehiclePO;
	}

	public boolean deleteVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return Database.delete("vehicle", "vehicleid", vehicleid);
	}

	public boolean modifyVehicle(VehiclePO vehiclePO) {
		// TODO Auto-generated method stub
		String vehicleid=vehiclePO.getVehicleid();
		String number=vehiclePO.getNumber();
		String age=vehiclePO.getAge();
		String var;
		var="number='"+number+"',age='"+age+"'";
		return Database.modify("vehicle", var,"vehicleid",vehicleid);
	}

}
