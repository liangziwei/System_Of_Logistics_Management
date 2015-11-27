package businessLogic.businessLogicController.managerController;

import businessLogic.businessLogicModel.managerModel.StaffManagement;
import businessLogicService.managerBLService.StaffManagementBLService;
import vo.managerVO.StaffVO;
/**
 * description:为人员管理界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class StaffManagementController implements StaffManagementBLService {
	
	private StaffManagement staff = new StaffManagement();
	
	public boolean addStaff(StaffVO staffVO) {
		return staff.addStaff(staffVO);
	}
	
	public StaffVO findStaff(String id) {
		return staff.findStaff(id);
	}
	
	public boolean deleteStaff(String id) {
		return staff.deleteStaff(id);
	}
	
	public boolean modifyStaff(StaffVO staffVO) {
		return staff.modifyStaff(staffVO);
	}
}
