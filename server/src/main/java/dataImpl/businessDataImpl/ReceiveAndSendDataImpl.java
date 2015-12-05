package dataImpl.businessDataImpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constant.CargoState;
import dataService.businessDataService.ReceiveAndSendDataService;
import mysql.Database;
import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;

public class ReceiveAndSendDataImpl implements ReceiveAndSendDataService {

	public boolean addReceiveFrom(ArrivalFormPO arrivalFormPO) {
		// TODO Auto-generated method stub
		String date=arrivalFormPO.getDate();
		String transitNumber=arrivalFormPO.getTransitNumber();
		String departPlace=arrivalFormPO.getDepartPlace();
		CargoState state=arrivalFormPO.getState();
		String val="";
		val="'"+date+"','"+transitNumber+"','"+departPlace+"','"+state.toString()+"',0,1";
				
		return Database.add("arrivalform",val);
	}

	public boolean addSendFrom(SendFormPO sendFormPO) {
		// TODO Auto-generated method stub
		 String date=sendFormPO.getDate();	
		 String deliveryid=sendFormPO.getDeliveryid();
		 String sender=sendFormPO.getSender();
		 String val;
		 val="'"+date+"','"+deliveryid+"','"+sender+"',0,1";
		return Database.add("sendform", val);
	}
	
	public ArrayList<ArrivalFormPO> getUncheckArrival() {
		ArrayList<ArrivalFormPO> po = new ArrayList<ArrivalFormPO>();
		String sql = "select * from arrivalForm where isApproved = 0;";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createArrivalForm(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	public ArrayList<SendFormPO> getUncheckSend() {
		ArrayList<SendFormPO> po = new ArrayList<SendFormPO>();
		String sql = "select * from sendForm where isApproved = 0;";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createSendForm(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	private ArrivalFormPO createArrivalForm(ResultSet rs) {
		try {
			String state = rs.getString("state");
			CargoState c = null;
			switch(state) {
			case "损坏":
				c = CargoState.损坏;
				break;
			case "完整":
				c = CargoState.完整;
				break;
			case "丢失":
				c = CargoState.丢失;
				break;
			}
			return new ArrivalFormPO(rs.getString("date"), rs.getString("transitNumber"),
					rs.getString("departPlace"), c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private SendFormPO createSendForm(ResultSet rs) {
		try {
			return new SendFormPO(rs.getString("date"), rs.getString("deliveryid"), rs.getString("sender"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean approveOneArrivalForm(ArrivalFormPO form) throws RemoteException {
		String sql = "update arrivalForm set isApproved = 1, isPassed = 1 where "
				+ "transitNumber = '" + form.getTransitNumber() + "';";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean approveMoreArrivalForm(ArrayList<ArrivalFormPO> form) throws RemoteException {
		int size = form.size();
		for(int i = 0; i < size; i++) {
			this.approveOneArrivalForm(form.get(i));
		}
		return true;
	}

	@Override
	public boolean approveOneSendForm(SendFormPO form) throws RemoteException {
		String sql = "update sendForm set isApproved = 1, isPassed = 1 where "
				+ "deliveryid = '" + form.getDeliveryid() + "';";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean approveMoreSendForm(ArrayList<SendFormPO> form) throws RemoteException {
		int size = form.size();
		for(int i = 0; i < size; i++) {
			this.approveOneSendForm(form.get(i));
		}
		return true;
	}

}
