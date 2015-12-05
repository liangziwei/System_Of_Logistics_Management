package businessLogic.businessLogicModel.businessModel;

import network.RMI;
import po.businessPO.DriverPO;
import stub.dataImpl_stub.businessDataImpl_stub.DriverDataImpl_Stub;
import vo.businessVO.DriverVO;
import dataService.businessDataService.DriverDataService;

public class Driver {

//	private DriverDataService driverData=new DriverDataImpl_Stub();
	private DriverDataService driverData=RMI.<DriverDataService>getDataService("driver");
	public boolean addDriver(DriverVO driverVO) {
		// TODO Auto-generated method stub
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
