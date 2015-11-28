package po.businessPO;

import java.io.Serializable;

public class VehiclePO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8315962433797210107L;
	
	private boolean isWrong =false;
	
	private String vehicleid;
	private String number;
	private String age;
	
	public VehiclePO(String vehicleid, String number, String age) {
		this.vehicleid = vehicleid;
		this.number = number;
		this.age = age;
	}
	
	
	public String getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	public void setWrong(boolean isWrong) {
		this.isWrong = isWrong;
	}
	
}
