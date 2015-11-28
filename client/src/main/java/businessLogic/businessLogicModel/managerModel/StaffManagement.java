package businessLogic.businessLogicModel.managerModel;


import dataService.managerDataService.StaffManagementDataService;
import network.RMI;
import po.managerPO.StaffPO;
import vo.managerVO.StaffVO;

public class StaffManagement {

	private StaffManagementDataService staffData = RMI.<StaffManagementDataService>getDataService("staff");
	
	public boolean addStaff(StaffVO staffVO) {
		boolean success = false;
		try{
			success = staffData.addStaff(StaffPO.staffVOTostaffPO(staffVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public StaffVO findStaff(String id) {
		StaffVO staff = null;
		try{
			StaffPO staffPO = staffData.findStaff(id);
			if(staffPO == null) return null;
			staff = StaffPO.staffPOTostaffVO(staffPO);
		}catch(Exception e){
			e.printStackTrace();
		}
		return staff;
	}
	
	public boolean deleteStaff(String id) {
		boolean success = false;
		try{
			success = staffData.deleteStaff(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean modifyStaff(StaffVO staffVO) {
		boolean success = false;
		try{
			success = staffData.modifyStaff(StaffPO.staffVOTostaffPO(staffVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
}
