package businessLogic.businessLogicModel.businessModel;

import po.businessPO.DriverPO;
import stub.dataImpl_stub.businessDataImpl_stub.DriverDataImpl_Stub;
import vo.businessVO.DriverVO;
import dataService.businessDataService.DriverDataService;
import network.RemoteExceptionHandler;

public class Driver {

	private DriverDataService driverData=new DriverDataImpl_Stub();
//	private DriverDataService driverData=RMI.<DriverDataService>getDataService("driver");
	
	private static final String KEY = "driver";
	
	public boolean addDriver(DriverVO driverVO) {
		return driverData.addDriver(driverVO.driverVOToPO());
	}

	public DriverVO findDriver(String driverid) {
		// TODO Auto-generated method stub
		DriverPO driverPO=driverData.findDriver(driverid);
		return driverPO.driverPOToVO();
	}

	public boolean deleteDriver(String driverid) {
		// TODO Auto-generated method stub
		return driverData.deleteDriver(driverid);
	}

	public boolean modifyDriver(DriverVO driverVO) {
		// TODO Auto-generated method stub
		return driverData.modifyDriver(driverVO.driverVOToPO());
	}

}
