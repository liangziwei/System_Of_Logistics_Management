package stub.dataImpl_stub.financeDataImpl_stub;

import po.financePO.PaymentPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.financeDataService.CostDataService;

public class CostDataImpl_Stub implements CostDataService{
	public boolean addPayment(PaymentPO paymentPO) {
		return false;
	}

	@Override
	public boolean approveOnePayment(PaymentPO form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveMorePayment(ArrayList<PaymentPO> form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
