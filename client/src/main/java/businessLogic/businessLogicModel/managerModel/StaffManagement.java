package businessLogic.businessLogicModel.managerModel;

import po.managerPO.StaffPO;
import vo.managerVO.StaffVO;
import mock.object.MockStaffData;
import dataService.managerDataService.StaffManagementDataService;

public class StaffManagement {

	private StaffManagementDataService staffData = new MockStaffData();
	
	public boolean addStaff(StaffVO staffVO) {
		return staffData.addStaff(this.staffVOTostaffPO(staffVO));
	}
	
	public StaffVO findStaff(String id) {
		return this.staffPOTostaffVO(staffData.findStaff(id));
	}
	
	public boolean deleteStaff(String id) {
		return staffData.deleteStaff(id);
	}
	
	public boolean modifyStaff(StaffVO staffVO) {
		return staffData.modifyStaff(this.staffVOTostaffPO(staffVO));
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
