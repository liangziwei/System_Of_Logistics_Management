package po.businessPO;

import java.util.ArrayList;

public class ReceivablePO {
	private String date;
	private double money;
	private String courier;//快递员
	private ArrayList<Long> deliveryid;
	
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
}
