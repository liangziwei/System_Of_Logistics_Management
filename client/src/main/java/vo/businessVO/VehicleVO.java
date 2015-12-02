package vo.businessVO;

import po.businessPO.VehiclePO;

public class VehicleVO {

	private boolean isWrong =false;
	private String vehicleid;
	private String number;
	private String age;
	
	public VehicleVO(String vehicleid, String number, String age) {
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


	public boolean isWrong() {
		return isWrong;
	}
	public VehiclePO vehicleVOToPO(){
		return new VehiclePO(vehicleid,number,age);
	}
}
