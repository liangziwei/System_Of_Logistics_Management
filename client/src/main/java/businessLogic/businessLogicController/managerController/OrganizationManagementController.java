package businessLogic.businessLogicController.managerController;

import vo.managerVO.OrganizationVO;
import businessLogicService.managerBLService.OrganizationManagementBLService;
/**
 * description:为机构管理界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class OrganizationManagementController implements OrganizationManagementBLService {
	
	public boolean addOrganization(OrganizationVO organizationVO) {
		return false;
	}
	
	public OrganizationVO findOrganization(String id) {
		return null;
	}
	
	public boolean deleteOrganization(String id) {
		return false;
	}
	
	public boolean modifyOrganization(OrganizationVO organizationVO) {
		return false;
	}

}
