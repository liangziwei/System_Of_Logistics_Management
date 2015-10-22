package vo.deliveryVO;

public class ReceiverInfo {

private String name;
	
	private String address;
	
	private String company;
	
	private String phoneNumber;
	
	private String mobileNumber;

	public ReceiverInfo(String name, String address, String company, 
			String phoneNumber, String mobileNumber) {
		super();
		this.name = name;
		this.address = address;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
	}

	String getName() {
		return name;
	}

	String getAddress() {
		return address;
	}

	String getCompany() {
		return company;
	}

	String getPhoneNumber() {
		return phoneNumber;
	}

	String getMobileNumber() {
		return mobileNumber;
	}
	
}
