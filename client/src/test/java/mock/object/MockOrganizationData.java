package mock.object;

import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;

import java.rmi.RemoteException;
import java.util.List;

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

	@Override
	public List<StaffPO> findStaffInfos(String organizationId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStaffsByOrgId(String organizationId) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
