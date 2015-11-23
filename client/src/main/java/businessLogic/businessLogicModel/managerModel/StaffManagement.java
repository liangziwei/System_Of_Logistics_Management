package businessLogic.businessLogicModel.managerModel;


import network.RMI;
import po.managerPO.StaffPO;
import vo.managerVO.StaffVO;
import dataService.managerDataService.StaffManagementDataService;

public class StaffManagement {

	private StaffManagementDataService staffData = RMI.<StaffManagementDataService>getDataService("staff");
	
	public boolean addStaff(StaffVO staffVO) {
		boolean success = false;
		try{
			success = staffData.addStaff(this.staffVOTostaffPO(staffVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public StaffVO findStaff(String id) {
		StaffVO staff = null;
		try{
			staff = this.staffPOTostaffVO(staffData.findStaff(id));
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
			success = staffData.modifyStaff(this.staffVOTostaffPO(staffVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	private StaffPO staffVOTostaffPO(StaffVO staffVO){
		return new StaffPO(staffVO.getName(),staffVO.getId(),staffVO.getPosition(),
				staffVO.getGender(),staffVO.getBirthday(),staffVO.getSalary());
	}
	
	private StaffVO staffPOTostaffVO(StaffPO staffPO){
		return new StaffVO(staffPO.getName(),staffPO.getId(),staffPO.getPosition(),
				staffPO.getGender(),staffPO.getBirthday(),staffPO.getSalary());
	}

}
