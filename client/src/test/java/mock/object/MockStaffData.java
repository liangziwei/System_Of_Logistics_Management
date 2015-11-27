package mock.object;

import po.managerPO.StaffPO;

import java.rmi.RemoteException;
import java.util.List;

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
