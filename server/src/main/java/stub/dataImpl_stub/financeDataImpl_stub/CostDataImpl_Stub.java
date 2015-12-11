package stub.dataImpl_stub.financeDataImpl_stub;

import po.financePO.PaymentPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.Approvable;
import dataService.financeDataService.CostDataService;

public class CostDataImpl_Stub implements CostDataService{
	public boolean addPayment(PaymentPO paymentPO) {
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
