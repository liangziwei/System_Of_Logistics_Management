package po.businessPO;

import java.io.Serializable;

public class DriverPO implements Serializable{
	private String driverid;
	private String name;
	private String birthday;
	private String idNumber;
	private String phoneNumber;
	private String gender;
	private String drivingDeadline;
	
	public DriverPO(String driverid, String name, String birthday,
			String idNumber, String phoneNumber, String gender,
			String drivingDeadline) {
		super();
		this.driverid = driverid;
		this.name = name;
		this.birthday = birthday;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.drivingDeadline = drivingDeadline;
	}
	
	public String getDriverid() {
		return driverid;
	}
	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDrivingDeadline() {
		return drivingDeadline;
	}
	public void setDrivingDeadline(String drivingDeadline) {
		this.drivingDeadline = drivingDeadline;
	}
	
}
