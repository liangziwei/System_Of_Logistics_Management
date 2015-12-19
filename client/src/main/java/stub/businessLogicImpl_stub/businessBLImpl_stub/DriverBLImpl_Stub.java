package stub.businessLogicImpl_stub.businessBLImpl_stub;

import java.rmi.RemoteException;

import po.businessPO.DriverPO;
import stub.dataImpl_stub.businessDataImpl_stub.DriverDataImpl_Stub;
import vo.businessVO.DriverVO;
import businessLogicService.businessBLService.DriverBLService;
import dataService.businessDataService.DriverDataService;

public class DriverBLImpl_Stub implements DriverBLService{
	
	private DriverDataService driverData=new DriverDataImpl_Stub();

	public boolean addDriver(DriverVO driverVO) {
		// TODO Auto-generated method stub
		try {
			return driverData.addDriver(driverVOToPO(driverVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public DriverVO findDriver(String driverid) {
		// TODO Auto-generated method stub
		try {
			return driverPOToVO(driverData.findDriver(driverid));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
			return driverData.modifyDriver(driverVOToPO(driverVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	private DriverPO driverVOToPO(DriverVO driverVO){
		return new DriverPO(driverVO.getDriverid(),driverVO.getName(),driverVO.getBirthday(),driverVO.getIdNumber(),driverVO.getPhoneNumber(),driverVO.getGender(),driverVO.getDrivingDeadline());
	}
	private DriverVO driverPOToVO(DriverPO driverPO){
		return new DriverVO(driverPO.getDriverid(),driverPO.getName(),driverPO.getBirthday(),driverPO.getIdNumber(),driverPO.getPhoneNumber(),driverPO.getGender(),driverPO.getDrivingDeadline());
	}

}
