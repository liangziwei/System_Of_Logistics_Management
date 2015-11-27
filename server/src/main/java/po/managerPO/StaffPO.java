package po.managerPO;

import java.io.Serializable;

/**
 * 记录了人员的信息
 * @author 张仁知
 */
public class StaffPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2070718225576742833L;
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
	
	private String salaryType;
	
	private boolean isApproved;
	
	private boolean isPassed;
	
	public StaffPO(String name, String id, String position, String gender,
			String birthday, String salary, String salaryType,
			boolean isApproved, boolean isPassed) {
		super();
		this.name = name;
		this.id = id;
		this.position = position;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
		this.salaryType = salaryType;
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
	public String getSalaryType() {
		return salaryType;
	}
	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
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
