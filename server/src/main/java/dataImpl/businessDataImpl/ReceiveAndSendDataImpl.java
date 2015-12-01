package dataImpl.businessDataImpl;

import mysql.Database;
import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;
import constant.CargoState;
import dataService.businessDataService.ReceiveAndSendDataService;

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

}
