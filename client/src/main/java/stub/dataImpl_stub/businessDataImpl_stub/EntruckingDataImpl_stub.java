package stub.dataImpl_stub.businessDataImpl_stub;

import po.businessPO.EntruckingPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.businessDataService.EntruckingDataService;

public class EntruckingDataImpl_stub implements EntruckingDataService{

	public boolean addEntruckingFrom(EntruckingPO entruckingPO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean approveOneEntrucking(EntruckingPO form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveMoreEntrucking(ArrayList<EntruckingPO> form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
