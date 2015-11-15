package mock.object;

import po.managerPO.OrganizationPO;
import dataService.managerDataService.OrganizationManagementDataService;

public class MockOrganizationData implements OrganizationManagementDataService{

	public boolean addOrganization(OrganizationPO organizationPO) {
		return false;
	}
	
	public OrganizationPO findOrganization(String id) {
		return null;
	}
	
	public boolean deleteOrganization(String id) {
		return false;
	}
	
	public boolean modifyOrganization(OrganizationPO organizationPO) {
		return false;
	}
}
