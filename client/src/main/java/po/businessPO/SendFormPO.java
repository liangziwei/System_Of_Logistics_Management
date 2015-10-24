package po.businessPO;

import java.io.Serializable;

public class SendFormPO implements Serializable{
	private String date;	
	private String deliveryid;
	private String sender;
	private boolean isApproved=false; 
	private boolean isPassed=true;
	
	public SendFormPO(String date, String deliveryid, String sender) {
		this.date = date;
		this.deliveryid = deliveryid;
		this.sender = sender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDeliveryid() {
		return deliveryid;
	}
	public void setDeliveryid(String deliveryid) {
		this.deliveryid = deliveryid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
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
