package stub.businessLogicImpl_stub.managerBLImpl_stub;

import po.managerPO.StaffPO;
import stub.dataImpl_stub.managerDataImpl_stub.StaffManagementDataImpl_Stub;
import vo.managerVO.StaffVO;
import businessLogicService.managerBLService.StaffManagementBLService;
import dataService.managerDataService.StaffManagementDataService;

public class StaffManagementBLImpl_Stub implements StaffManagementBLService {
	
	private StaffManagementDataService staff = new StaffManagementDataImpl_Stub();
	
	public boolean addStaff(StaffVO staffVO) {
		return staff.addStaff(this.staffVOTostaffPO(staffVO));
	}
	
	public StaffVO findStaff(String id) {
		return this.staffPOTostaffVO(staff.findStaff(id));
	}
	
	public boolean deleteStaff(String id) {
		return staff.deleteStaff(id);
	}
	
	public boolean modifyStaff(StaffVO staffVO) {
		return staff.modifyStaff(this.staffVOTostaffPO(staffVO));
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
