package mock.object;

import po.managerPO.StaffPO;
import dataService.managerDataService.StaffManagementDataService;

public class MockStaffData implements StaffManagementDataService{

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
