package dataImpl.transitionDataImpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constant.CargoState;
import dataService.Approvable;
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
			e.printStackTrace();
			return false;
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
	
	public ArrayList<ReceivingPO> getUncheckReceiving() {
		ArrayList<ReceivingPO> po = new ArrayList<ReceivingPO>();
		String sql = "select * from receiving where isApproved = 0;";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createReceivingPO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	private ReceivingPO createReceivingPO(ResultSet rs) {
		try {
			String temp = rs.getString("state");
			CargoState state = null;
			switch(temp) {
			case "DAMAGE":
				state = CargoState.损坏;
				break;
			case "INTACT":
				state = CargoState.完整;
				break;
			case "LOSE":
				state = CargoState.丢失;
				break;
			}
			return new ReceivingPO(rs.getString("transitionid"), rs.getString("arrivaldate"),
					rs.getString("transferringid"), rs.getString("departureid"),
					rs.getString("arrivalid"), state);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public boolean approveOneReceiving(ReceivingPO form) throws RemoteException {
//		
//	}
//
//	@Override
//	public boolean approveMoreReceiving(ArrayList<ReceivingPO> form) throws RemoteException {
//		int size = form.size();
//		for(int i = 0; i < size; i++) {
//			this.approveOneReceiving(form.get(i));
//		}
//		return true;
//	}

	@Override
	public boolean ApproveOneForm(Approvable form) throws RemoteException {
		String sql = "update receiving set isApproved = 1, isPassed = 1 where "
				+ "transferringid = '" + ((ReceivingPO)form).gettransferringid() + "';";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ApproveMoreForm(ArrayList<? extends Approvable> forms) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
