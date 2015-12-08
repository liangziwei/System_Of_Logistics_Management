package stub.businessLogicImpl_stub.managerBLImpl_stub;

import businessLogicService.managerBLService.StaffManagementBLService;
import dataService.managerDataService.StaffManagementDataService;
import po.managerPO.StaffPO;
import stub.dataImpl_stub.managerDataImpl_stub.StaffManagementDataImpl_Stub;
import vo.managerVO.StaffVO;

public class StaffManagementBLImpl_Stub implements StaffManagementBLService {
	
	private StaffManagementDataService staff = new StaffManagementDataImpl_Stub();
	
	public boolean addStaff(StaffVO staffVO) {
		boolean success = false;
		try{
			success = staff.addStaff(this.staffVOTostaffPO(staffVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public StaffVO findStaff(String id) {
		StaffVO staffVO = null;
		try{
			staffVO = this.staffPOTostaffVO(staff.findStaff(id)); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return staffVO;
	}
	
	public boolean deleteStaff(String id) {
		boolean success = false;
		try{ 
			success = staff.deleteStaff(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean modifyStaff(StaffVO staffVO) {
		boolean success = false;
		try{
			success = staff.modifyStaff(this.staffVOTostaffPO(staffVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	private StaffPO staffVOTostaffPO(StaffVO staffVO){
//		return new StaffPO(staffVO.getName(),staffVO.getId(),staffVO.getPosition(),
//				staffVO.getGender(),staffVO.getBirthday(),staffVO.getSalary());
		return null;
	}
	
	private StaffVO staffPOTostaffVO(StaffPO staffPO){
//		return new StaffVO(staffPO.getName(),staffPO.getId(),staffPO.getPosition(),
//				staffPO.getGender(),staffPO.getBirthday(),staffPO.getSalary());
		return null;
	}

}
