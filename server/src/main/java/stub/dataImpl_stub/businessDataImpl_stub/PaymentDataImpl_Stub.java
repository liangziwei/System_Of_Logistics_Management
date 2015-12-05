package stub.dataImpl_stub.businessDataImpl_stub;

import po.businessPO.ReceivablePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.businessDataService.PaymentDataService;

public class PaymentDataImpl_Stub implements  PaymentDataService {

	public boolean addPayentForm(ReceivablePO paymentPO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean approveOneReceivable(ReceivablePO form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveMoreReceivable(ArrayList<ReceivablePO> form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
