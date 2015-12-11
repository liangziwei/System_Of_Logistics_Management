package stub.dataImpl_stub.repositoryDataImpl_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import constant.AreaCodeType;
import dataService.Approvable;
import dataService.repositoryDataService.InRepositoryDataService;
import po.repositoryPO.InRepositoryPO;

public class InRepositoryDataImpl_Stub implements InRepositoryDataService{

	public boolean AddInRepositoryFormDT(InRepositoryPO inRepositoryPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean ModifyInRepositoryFormDT(InRepositoryPO inRepository) {
		// TODO Auto-generated method stub
		return true;
	}

	public InRepositoryPO FindInRepositoryFormDT(String InRepositoryNumber) {
		// TODO Auto-generated method stub
		return new InRepositoryPO("1110101023","2015-10-13", "北京",AreaCodeType.PLANEAREA,"004","012","042");
	}

	public boolean UpdateRepositoryInfoDT(InRepositoryPO inRepository) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean modifyUpdateRepositoryInfoDT(InRepositoryPO inRepository) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ApproveOneForm(Approvable form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ApproveMoreForm(ArrayList<? extends Approvable> forms) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
