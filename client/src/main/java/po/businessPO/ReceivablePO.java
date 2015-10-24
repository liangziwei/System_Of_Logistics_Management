package po.businessPO;

import java.io.Serializable;
import java.util.ArrayList;

public class ReceivablePO implements Serializable{
	private String date;
	private double money;
	private String courier;//快递员
	private ArrayList<Long> deliveryid;
	private boolean isApproved=false; 
	private boolean isPassed=true;
	
	public ReceivablePO(String date, double money, String courier,
			ArrayList<Long> deliveryid) {
		this.date = date;
		this.money = money;
		this.courier = courier;
		this.deliveryid = deliveryid;
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

	public ArrayList<Long> getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(ArrayList<Long> deliveryid) {
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
	
}
