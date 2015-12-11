package stub.dataImpl_stub.businessDataImpl_stub;

import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.Approvable;
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
