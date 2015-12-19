package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import dataService.businessDataService.DriverDataService;
import network.RMI;
import po.businessPO.DriverPO;
import vo.businessVO.DriverVO;

public class Driver {

	private DriverDataService driverData=RMI.<DriverDataService>getDataService(KEY);
	
	private static final String KEY = "driver";
	
	public boolean addDriver(DriverVO driverVO) {
		// TODO Auto-generated method stub
		try {
			return driverData.addDriver(driverVO.driverVOToPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public DriverVO findDriver(String driverid) {
		// TODO Auto-generated method stub
		DriverPO driverPO = null;
		try {
			driverPO = driverData.findDriver(driverid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driverPO.driverPOToVO();
	}

	public boolean deleteDriver(String driverid) {
		// TODO Auto-generated method stub
		try {
			return driverData.deleteDriver(driverid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyDriver(DriverVO driverVO) {
		// TODO Auto-generated method stub
		try {
			return driverData.modifyDriver(driverVO.driverVOToPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
