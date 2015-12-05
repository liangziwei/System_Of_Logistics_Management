package mock.object;

import po.financePO.PaymentPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.financeDataService.CostDataService;

public class MockCostData implements CostDataService{
	public boolean addPayment(PaymentPO paymentPO){
		return true;
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
