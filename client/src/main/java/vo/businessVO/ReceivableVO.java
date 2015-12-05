package vo.businessVO;

import java.util.ArrayList;

import po.businessPO.ReceivablePO;
import vo.ApprovalFormVO;

public class ReceivableVO extends ApprovalFormVO{

	private String date;
	private double money;
	private String courier;//快递员
	private ArrayList<String> deliveryid;
	private String businessID;
	
	public ReceivableVO(String date, double money, String courier,
			ArrayList<String> deliveryid,String businessID) {
		super();
		this.date = date;
		this.money = money;
		this.courier = courier;
		this.deliveryid = deliveryid;
		this.businessID=businessID;
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
	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	public ReceivablePO receivableVOToPO(){
		return new ReceivablePO(date,money,courier,deliveryid,businessID);
	}
}
