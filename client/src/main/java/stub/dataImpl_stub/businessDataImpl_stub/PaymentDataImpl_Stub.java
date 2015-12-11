package stub.dataImpl_stub.businessDataImpl_stub;

import po.businessPO.ReceivablePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.Approvable;
import dataService.businessDataService.PaymentDataService;

public class PaymentDataImpl_Stub implements  PaymentDataService {

	public boolean addPayentForm(ReceivablePO paymentPO) {
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
