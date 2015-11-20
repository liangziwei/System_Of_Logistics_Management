package stub.dataImpl_stub.managerDataImpl_stub;

import java.util.ArrayList;

import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import dataService.managerDataService.OrganizationManagementDataService;

public class OrganizationManagementDataImpl_Stub implements OrganizationManagementDataService{
	public boolean addOrganization(OrganizationPO organizationPO) {
		return false;
	}
	
	public OrganizationPO findOrganization(String id) {
		ArrayList<StaffPO> staffInfo = new ArrayList<StaffPO>();
		staffInfo.add(new StaffPO("小明", "B1235468", "快递员", "男","1987-02-15", "按提成"));
		staffInfo.add(new StaffPO("小李", "B1289568", "业务员", "男","1984-08-11", "按月"));
		staffInfo.add(new StaffPO("小王", "B1784468", "快递员", "男","1988-04-25", "按提成"));
		return new OrganizationPO("营业厅", "00002500010000", "南京市鼓楼营业厅", staffInfo);
	}
	
	public boolean deleteOrganization(String id) {
		return false;
	}
	
	public boolean modifyOrganization(OrganizationPO organizationPO) {
		return false;
	}
}
