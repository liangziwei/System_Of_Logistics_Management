package businessLogic.businessLogicController.managerController;

import vo.managerVO.OrganizationVO;
import businessLogic.businessLogicModel.managerModel.OrganizationManagement;
import businessLogicService.managerBLService.OrganizationManagementBLService;
/**
 * description:为机构管理界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class OrganizationManagementController implements OrganizationManagementBLService {
	
	
	private OrganizationManagement organization = new OrganizationManagement();
	
	public boolean addOrganization(OrganizationVO organizationVO) {
		return organization.addOrganization(organizationVO);
	}
	
	public OrganizationVO findOrganization(String id) {
		return organization.findOrganization(id);
	}
	
	public boolean deleteOrganization(String id) {
		return organization.deleteOrganization(id);
	}
	
	public boolean modifyOrganization(OrganizationVO organizationVO) {
		return organization.modifyOrganization(organizationVO);
	}

}
