package dataImpl.businessDataImpl;

import java.util.ArrayList;

import mysql.Database;
import po.businessPO.ReceivablePO;
import dataService.businessDataService.PaymentDataService;

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
		String delivery=deliveryList.get(0);
		for(int i=1;i<deliveryList.size();i++){
			delivery=delivery+" "+deliveryList.get(i);
		}
		String val="";
		val="'"+date+"',"+money+",'"+courier+"','"+delivery+"',0,1";
		// TODO Auto-generated method stub
		return Database.add("receivable", val);
	}

}
