package stub.dataImpl_stub.transitionDataImpl_stub;
import java.lang.Thread.State;
import java.rmi.RemoteException;
import java.util.ArrayList;

import constant.CargoState;
import dataService.transitionDataService.ReceivingDataService;
import po.transitionPO.ReceivingPO;

public class ReceivingDataImpl_Stub implements ReceivingDataService{

	public boolean addReceivingFormDT(ReceivingPO receivingPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean modifyReceivingFormDT(ReceivingPO receivingPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public ReceivingPO FindReceivingFormDT(String receivingNumber) {
		// TODO Auto-generated method stub
//		return new ReceivingPO("0025 010","2015-10-8", "20151008000017","北京","南京",CargoState.INTACT);
		return null;
	}

	@Override
	public boolean approveOneReceiving(ReceivingPO form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveMoreReceiving(ArrayList<ReceivingPO> form) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
