package po.businessPO;

import java.io.Serializable;
import java.util.ArrayList;

import dataService.Approvable;
import vo.businessVO.SendFormVO;

public class SendFormPO implements Serializable, Approvable{
	
	private static final long serialVersionUID = -2326119319668011673L;
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
	
	public SendFormVO sendFormPOToVO(){
		return new SendFormVO(date,deliveryid,sender);
	}
	
	public static SendFormPO sendFormVOToPO(SendFormVO vo) {
		return new SendFormPO(vo.getDate(), vo.getDeliveryid(), vo.getSender());
	}
	
	public static ArrayList<SendFormPO> senFormVOListToPO(ArrayList<SendFormVO> list) {
		ArrayList<SendFormPO> po = new ArrayList<SendFormPO>();
		int size = list.size();
		for(int i = 0; i < size; i++) {
			po.add(sendFormVOToPO(list.get(i)));
		}
		return po;
	}
	
	public static ArrayList<SendFormVO> sendFormPOListToVO(ArrayList<SendFormPO> po) {
		ArrayList<SendFormVO> vo = new ArrayList<SendFormVO>();
		int size = po.size();
		for(int i = 0; i < size; i++) {
			vo.add(po.get(i).sendFormPOToVO());
		}
		return vo;
	}
}
