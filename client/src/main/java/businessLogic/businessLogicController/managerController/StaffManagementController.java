package businessLogic.businessLogicController.managerController;

import vo.managerVO.StaffVO;
import businessLogicService.managerBLService.StaffManagementBLService;
/**
 * description:为人员管理界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class StaffManagementController implements StaffManagementBLService {
	
	public boolean addStaff(StaffVO staffVO) {
		return false;
	}
	
	public StaffVO findStaff(String id) {
		return null;
	}
	
	public boolean deleteStaff(String id) {
		return false;
	}
	
	public boolean modifyStaff(StaffVO staffVO) {
		return false;
	}

}
