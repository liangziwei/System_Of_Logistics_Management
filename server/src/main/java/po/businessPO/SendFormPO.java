package po.businessPO;

public class SendFormPO {
	private String date;	
	private String deliveryid;
	private String sender;
	
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
	
}
