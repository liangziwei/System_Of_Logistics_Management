package dataImpl.financeDataImpl;

import java.rmi.RemoteException;
import java.util.List;

import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryPO;
import dataService.financeDataService.OriginalInfoDataService;

public class OriginalInfoRecordDataImpl implements OriginalInfoDataService {

	@Override
	public List<StaffPO> getStaffInfo(int year) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizationPO> getOrganizationInfo(int year)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehiclePO> getVehicleInfo(int year) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RepositoryPO> getRepositoryInfo(int year)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountPO> getAccountInfo(int year) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
