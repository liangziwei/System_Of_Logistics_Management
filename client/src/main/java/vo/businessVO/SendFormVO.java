package vo.businessVO;

import dataService.Approvable;
import po.businessPO.SendFormPO;

public class SendFormVO implements Approvable{

	private String date;	
	private String deliveryid;
	private String sender;
	private String businessID;
	
	public SendFormVO(String date, String deliveryid, String sender) {
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

	public String getBusinessID() {
		return businessID;
	}
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	public SendFormPO sendFormVOToPO(){
		return new SendFormPO(date,deliveryid,sender);
	}
}
