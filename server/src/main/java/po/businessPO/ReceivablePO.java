package po.businessPO;

import java.io.Serializable;
import java.util.ArrayList;

import dataService.Approvable;

public class ReceivablePO implements Serializable, Approvable{
	
	private static final long serialVersionUID = 6976620841885362041L;
	private String date;
	private double money;
	private String courier;//快递员
	private ArrayList<String> deliveryid;
	private String businessID;
	private boolean isApproved=false; 
	private boolean isPassed=true;
	
	public ReceivablePO(String date, double money, String courier,
			ArrayList<String> deliveryid,String businessID) {
		this.date = date;
		this.money = money;
		this.courier = courier;
		this.deliveryid = deliveryid;
		this.businessID = businessID;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public ArrayList<String> getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(ArrayList<String> deliveryid) {
		this.deliveryid = deliveryid;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}

	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	
}
