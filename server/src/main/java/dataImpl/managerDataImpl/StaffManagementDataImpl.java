package dataImpl.managerDataImpl;

import po.managerPO.StaffPO;
import dataService.managerDataService.StaffManagementDataService;

/**
 * description:数据服务层为人员管理提供服务的具体实现
 * @author 张仁知
 */
public class StaffManagementDataImpl implements StaffManagementDataService{

	public boolean addStaff(StaffPO staffPO) {
		return false;
	}
	
	public StaffPO findStaff(String id) {
		return null;
	}
	
	public boolean deleteStaff(String id) {
		return false;
	}
	
	public boolean modifyStaff(StaffPO staffPO) {
		return false;
	}
}
