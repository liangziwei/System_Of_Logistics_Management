package vo.deliveryVO;

/**
 * 记录了客户的信息
 * @author 肖安祥
 */
public class ClientInfo {
	
	/**
	 * 身份（寄件人或收件人）
	 */
	private String identity;

	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 住址
	 */
	private String address;
	
	/**
	 * 单位
	 */
	private String company;
	
	/**
	 * 电话
	 */
	private String phoneNumber;
	
	/**
	 * 手机
	 */
	private String mobileNumber;

	public ClientInfo(String identity, String name, String address, String company, 
			String phoneNumber, String mobileNumber) {
		super();
		this.identity = identity;
		this.name = name;
		this.address = address;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}