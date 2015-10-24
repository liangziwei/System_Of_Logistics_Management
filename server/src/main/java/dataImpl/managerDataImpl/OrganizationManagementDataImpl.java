package dataImpl.managerDataImpl;

import po.managerPO.OrganizationPO;
import dataService.managerDataService.OrganizationManagementDataService;

/**
 * description:数据服务层为机构管理提供服务的具体实现
 * @author 张仁知
 */
public class OrganizationManagementDataImpl implements OrganizationManagementDataService{

	public boolean addOrganization(OrganizationPO organizationPO) {
		return false;
	}
	
	public OrganizationPO findOrganization(int id) {
		return null;
	}
	
	public boolean deleteOrganization(int id) {
		return false;
	}
	
	public boolean modifyOrganization(OrganizationPO organizationPO) {
		return false;
	}
}
