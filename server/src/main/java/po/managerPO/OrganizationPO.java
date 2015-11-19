package po.managerPO;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 记录了机构的信息
 * @author 张仁知
 */
public class OrganizationPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4704429741521430274L;
	/**
	 * 机构类型
	 */
	private String type;
	/**
	 * 机构编号
	 */
	private String id;
	/**
	 * 机构名称
	 */
	private String name;
	/**
	 * 人员信息
	 */
	private ArrayList<StaffPO> staffInfo;
	public OrganizationPO(String type, String id, String name,
			ArrayList<StaffPO> staffInfo) {
		super();
		this.type = type;
		this.id = id;
		this.name = name;
		this.staffInfo = staffInfo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<StaffPO> getStaffInfo() {
		return staffInfo;
	}
	public void setStaffInfo(ArrayList<StaffPO> staffInfo) {
		this.staffInfo = staffInfo;
	}
	
	
}
