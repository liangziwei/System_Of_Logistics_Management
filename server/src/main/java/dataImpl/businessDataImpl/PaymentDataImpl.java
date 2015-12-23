package dataImpl.businessDataImpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataService.Approvable;
import dataService.businessDataService.PaymentDataService;
import mysql.Database;
import po.businessPO.ReceivablePO;

public class PaymentDataImpl implements PaymentDataService {

	String date;
	double money;
	String courier;
	String deliveryid;
	ArrayList<String> deliveryList;
	
	public boolean addPayentForm(ReceivablePO receivablePO) {
		date=receivablePO.getDate();
		money=receivablePO.getMoney();
		courier=receivablePO.getCourier();
		deliveryList=receivablePO.getDeliveryid();
		String businessid=receivablePO.getBusinessID();
		String delivery=deliveryList.get(0);
		for(int i=1;i<deliveryList.size();i++){
			delivery=delivery+" "+deliveryList.get(i);
		}
		String val="";
		val="'"+date+"',"+money+",'"+courier+"','"+delivery+"','"+businessid+"',0,1";
		// TODO Auto-generated method stub
		return Database.add("receivable", val);
	}
	
	public ArrayList<ReceivablePO> getUncheckReceivable() {
		ArrayList<ReceivablePO> po = new ArrayList<ReceivablePO>();
		String sql = "select * from receivable where isApproved = 0;";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createReceivablePO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	private ReceivablePO createReceivablePO(ResultSet rs) {
		try {
			String text = rs.getString("deliveryid");
			ArrayList<String> id = new ArrayList<String>();
			String[] temp = text.split(" ");
			int len = temp.length;
			for(int i = 0; i < len; i++) {
				id.add(temp[i]);
			}
			return new ReceivablePO(rs.getString("date"), rs.getDouble("money"), 
					rs.getString("courier"), id,rs.getString("businessID"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean ApproveOneForm(Approvable form) throws RemoteException {
		String sql = "update receivable set isApproved = 1, isPassed = 1 where "
				+ "money = " + ((ReceivablePO)form).getMoney() + ";";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ApproveMoreForm(ArrayList<? extends Approvable> forms) throws RemoteException {
		for (Approvable a : forms) {
			this.ApproveOneForm(a);
		}
		return true;
	}

}
