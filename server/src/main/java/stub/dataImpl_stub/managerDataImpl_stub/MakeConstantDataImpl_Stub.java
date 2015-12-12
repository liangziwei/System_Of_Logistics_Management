package stub.dataImpl_stub.managerDataImpl_stub;

import java.rmi.RemoteException;
import java.util.HashMap;

import dataService.managerDataService.MakeConstantDataService;
import po.constant.DistanceTable;
import po.constant.PackPrice;
import po.constant.TransitPrice;

public class MakeConstantDataImpl_Stub implements MakeConstantDataService{

	@Override
	public PackPrice getPackPrice() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePackPrice(PackPrice price) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TransitPrice getTransitPrice() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveTransitPrice(TransitPrice price) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DistanceTable getDistantceConstant() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveDistanceConstant(DistanceTable distance) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashMap<String, String> getIDTable() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
