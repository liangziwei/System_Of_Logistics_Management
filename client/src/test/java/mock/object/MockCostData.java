package mock.object;

import po.financePO.PaymentPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.Approvable;
import dataService.financeDataService.CostDataService;

public class MockCostData implements CostDataService{
	public boolean addPayment(PaymentPO paymentPO){
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
