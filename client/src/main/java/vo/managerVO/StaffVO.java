package vo.managerVO;

/**
 * 记录了人员的信息
 * @author 张仁知
 */
public class StaffVO {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * ID编号
	 */
	private String id;
	/**
	 * 职位
	 */
	private String position;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 薪水（按提成、按次还是按月）
	 */
	private String salary;
	
	private String type;
	
	private boolean isApproved;
	
	private boolean isPassed;
	
	public StaffVO(String name, String id, String position, String gender,
			String birthday, String salary, String type,
			boolean isApproved, boolean isPassed) {
		super();
		this.name = name;
		this.id = id;
		this.position = position;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
		this.type = type;
		this.isApproved = isApproved;
		this.isPassed = isPassed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
