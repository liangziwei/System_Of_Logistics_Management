package stub.dataImpl_stub.businessDataImpl_stub;

import po.businessPO.DriverPO;
import dataService.businessDataService.DriverDataService;

public class DriverDataImpl_Stub implements DriverDataService {

	public boolean addDriver(DriverPO driverPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public DriverPO findDriver(String driverid) {
		// TODO Auto-generated method stub
		return new DriverPO("025001001","大黄","1887-05-01","012345678912345","01234567890","男","1");
	}

	public boolean deleteDriver(String driverid) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean modifyDriver(DriverPO driverPO) {
		// TODO Auto-generated method stub
		return true;
	}

}
