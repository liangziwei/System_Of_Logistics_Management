package po.businessPO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataService.Approvable;

public class EntruckingPO implements Serializable, Approvable{
	
	private static final long serialVersionUID = -5974465357631427989L;
	private String date;
	private String businessHallid;
	private String transportNumber;
	private String destionation;
	private String vehicleid;
	private String supervisor;//监装员
	private String supercargo;//押运员
	private double freight;//运费
	private List<String> deliveryIDList=new ArrayList<String>();
	private boolean isApproved=false; 
	private boolean isPassed=true;

	public EntruckingPO(String date, String businessHallid,
			String transportNumber, String destionation, String vehicleid,
			String supervisor, String supercargo,double freight) {
		this.date = date;
		this.businessHallid = businessHallid;
		this.transportNumber = transportNumber;
		this.destionation = destionation;
		this.vehicleid = vehicleid;
		this.supervisor = supervisor;
		this.supercargo = supercargo;
		this.freight = freight;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBusinessHallid() {
		return businessHallid;
	}

	public void setBusinessHallid(String businessHallid) {
		this.businessHallid = businessHallid;
	}

	public String getTransportNumber() {
		return transportNumber;
	}

	public void setTransportNumber(String transportNumber) {
		this.transportNumber = transportNumber;
	}

	public String getDestionation() {
		return destionation;
	}

	public void setDestionation(String destionation) {
		this.destionation = destionation;
	}

	public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getSupercargo() {
		return supercargo;
	}

	public void setSupercargo(String supercargo) {
		this.supercargo = supercargo;
	}
	
	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public List<String> getDeliveryIDList() {
		return deliveryIDList;
	}

	public void setDeliveryIDList(List<String> deliveryIDList) {
		this.deliveryIDList = deliveryIDList;
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
