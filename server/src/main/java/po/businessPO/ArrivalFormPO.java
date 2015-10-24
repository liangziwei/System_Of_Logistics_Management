package po.businessPO;


import java.io.Serializable;

import constant.CargoState;


public class ArrivalFormPO implements Serializable{

	private String date;
	private String transitNumber;
	private String departPlace;
	private constant.CargoState state;
	private boolean isApproved=false; 
	private boolean isPassed=true;
	
	public ArrivalFormPO(String date, String transitNumber, String departPlace,
			constant.CargoState state) {
		this.date = date;
		this.transitNumber = transitNumber;
		this.departPlace = departPlace;
		this.state = state;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransitNumber() {
		return transitNumber;
	}
	public void setTransitNumber(String transitNumber) {
		this.transitNumber = transitNumber;
	}
	public String getDepartPlace() {
		return departPlace;
	}
	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}
	public CargoState getState() {
		return state;
	}
	public void setState(CargoState state) {
		this.state = state;
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
