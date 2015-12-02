package dataImpl.transitionDataImpl;

import java.sql.ResultSet;

import constant.CargoState;
import dataService.transitionDataService.ReceivingDataService;
import mysql.Database;
import po.transitionPO.ReceivingPO;

public class ReceivingDataImpl implements ReceivingDataService {

	ResultSet rs;

	public ReceivingPO FindReceivingFormDT(String receivingNumber) {
		// TODO Auto-generated method stub
		String transferringid = receivingNumber;
		String transitionid = null;
		String arrivaldate = null;
		String departureid = null;
		String arrivalid = null;
		CargoState state = null;
		boolean isApproval = false;
		boolean isPass = false;
		try {
			rs = Database.query("receiving", "transferringid", receivingNumber);
			while (rs.next()) {
				transitionid = rs.getString("transitionid");
				arrivaldate = rs.getString("arrivaldate");
				departureid = rs.getString("departureid");
				arrivalid = rs.getString("arrivalid");
				state = CargoState.valueOf(rs.getString("state"));
				isApproval = Boolean.parseBoolean(rs.getString("isApproved"));
				isPass = Boolean.parseBoolean(rs.getString("isPassed"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (state == null) {
			return null;
		}

		ReceivingPO receiving = new ReceivingPO(transitionid, arrivaldate, transferringid, departureid, arrivalid,
				state);
		receiving.setisApproved(isApproval);
		receiving.setisPassed(isPass);
		return receiving;
	}

	public boolean addReceivingFormDT(ReceivingPO receivingPO) {
		// TODO Auto-generated method stub
		String transferringid = receivingPO.gettransferringid();
		String transitionid = receivingPO.gettransitionid();
		String arrivaldate = receivingPO.getarrivaldate();
		String departureid = receivingPO.getdepartureid();
		String arrivalid = receivingPO.getarrivalid();
		CargoState state = receivingPO.getstate();
		String val = "";
		val = "'" + transferringid + "','" + transitionid + "','" + arrivaldate + "','" + departureid + "','"
				+ arrivalid + "','" + state.toString() + "'," + "0,1";
		boolean add = false;
		try {
			add = Database.add("receiving", val);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return add;
	}

	public boolean modifyReceivingFormDT(ReceivingPO receivingPO) {
		// TODO Auto-generated method stub
		String transferringid = receivingPO.gettransferringid();
		String transitionid = receivingPO.gettransitionid();
		String arrivaldate = receivingPO.getarrivaldate();
		String departureid = receivingPO.getdepartureid();
		String arrivalid = receivingPO.getarrivalid();
		CargoState state = receivingPO.getstate();
		String val = "";
		val = "transitionid='" + transitionid + "',arrivaldate='" + arrivaldate + "',departureid='" + departureid
				+ "',arrivalid='" + arrivalid + "',state='" + state.toString() + "',isApproved=0,isPassed=1";
		return Database.modify("receiving", val, "transferringid", transferringid);
	}

}
