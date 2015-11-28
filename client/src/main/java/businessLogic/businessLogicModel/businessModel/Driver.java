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
		return driverData.addDriver(driverVOToPO(driverVO));
	}

	public DriverVO findDriver(String driverid) {
		// TODO Auto-generated method stub
		return driverPOToVO(driverData.findDriver(driverid));
	}

	public boolean deleteDriver(String driverid) {
		// TODO Auto-generated method stub
		return driverData.deleteDriver(driverid);
	}

	public boolean modifyDriver(DriverVO driverVO) {
		// TODO Auto-generated method stub
		return driverData.modifyDriver(driverVOToPO(driverVO));
	}
	private DriverPO driverVOToPO(DriverVO driverVO){
		return new DriverPO(driverVO.getDriverid(),driverVO.getName(),driverVO.getBirthday(),driverVO.getIdNumber(),driverVO.getPhoneNumber(),driverVO.getGender(),driverVO.getDrivingDeadline());
	}
	private DriverVO driverPOToVO(DriverPO driverPO){
		return new DriverVO(driverPO.getDriverid(),driverPO.getName(),driverPO.getBirthday(),driverPO.getIdNumber(),driverPO.getPhoneNumber(),driverPO.getGender(),driverPO.getDrivingDeadline());
	}

}
