package po.businessPO;

import java.io.Serializable;
import java.util.ArrayList;

import vo.businessVO.ReceivableVO;

public class ReceivablePO implements Serializable{
	/**
	 * 
	 */
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
		this.businessID=businessID;
	}
	
	public static ReceivableVO ReceiptPOToVO(ReceivablePO po) {
		return new ReceivableVO(po.getDate(), po.getMoney(), po.getCourier(), po.getDeliveryid(),po.getBusinessID());
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
	
	public ReceivableVO receivablePOToVO(){
		return new ReceivableVO(date,money,courier,deliveryid,businessID);
	}
	
	public static ArrayList<ReceivablePO> receivableVOListToPO(ArrayList<ReceivableVO> list) {
		ArrayList<ReceivablePO> po = new ArrayList<ReceivablePO>();
		int size = list.size();
		for(int i = 0; i < size; i++) {
			po.add(list.get(i).receivableVOToPO());
		}
		return po;
	}
	
	public static ArrayList<ReceivableVO> receivablePOListToVO(ArrayList<ReceivablePO> po) {
		ArrayList<ReceivableVO> vo = new ArrayList<ReceivableVO>();
		int size = po.size();
		for(int i = 0; i < size; i++) {
			vo.add(po.get(i).receivablePOToVO());
		}
		return vo;
	}

	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
}
