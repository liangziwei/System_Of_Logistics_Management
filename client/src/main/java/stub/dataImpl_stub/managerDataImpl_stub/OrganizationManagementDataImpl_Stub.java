package stub.dataImpl_stub.managerDataImpl_stub;

import java.util.ArrayList;

import po.managerPO.OrganizationPO;
import dataService.managerDataService.OrganizationManagementDataService;

public class OrganizationManagementDataImpl_Stub implements OrganizationManagementDataService{
	public boolean addOrganization(OrganizationPO organizationPO) {
		return false;
	}
	
	public OrganizationPO findOrganization(String id) {
		ArrayList<String> staffInfo = new ArrayList<String>();
		staffInfo.add("B1235468");
		staffInfo.add("B1289568");
		staffInfo.add("B1784468");
		return new OrganizationPO("营业厅", "00002500010000", "南京市鼓楼营业厅", staffInfo);
	}
	
	public boolean deleteOrganization(String id) {
		return false;
	}
	
	public boolean modifyOrganization(OrganizationPO organizationPO) {
		return false;
	}
}
