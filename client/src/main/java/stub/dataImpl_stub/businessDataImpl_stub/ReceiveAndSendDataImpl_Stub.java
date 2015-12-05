package stub.dataImpl_stub.businessDataImpl_stub;

import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.businessDataService.ReceiveAndSendDataService;

public class ReceiveAndSendDataImpl_Stub implements ReceiveAndSendDataService {

	public boolean addReceiveFrom(ArrivalFormPO arrivalFormPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean addSendFrom(SendFormPO sendFormPO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean approveOneArrivalForm(ArrivalFormPO form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveMoreArrivalForm(ArrayList<ArrivalFormPO> form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveOneSendForm(SendFormPO form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveMoreSendForm(ArrayList<SendFormPO> form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
