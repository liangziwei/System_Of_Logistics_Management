package stub.businessLogicImpl_stub.businessBLImpl_stub;

import java.rmi.RemoteException;

import po.businessPO.VehiclePO;
import stub.dataImpl_stub.businessDataImpl_stub.VehicleDataImpl_Stub;
import vo.businessVO.VehicleVO;
import businessLogicService.businessBLService.VehicleBLService;
import dataService.businessDataService.VehicleDataService;

public class VehicleBLImpl_Stub implements VehicleBLService{

	private VehicleDataService vehicleData=new VehicleDataImpl_Stub();
	
	public boolean addVehicle(VehicleVO vehicleVO) {
		// TODO Auto-generated method stub
		
		try {
			return vehicleData.addVehicle(vehicleVOToPO(vehicleVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public VehicleVO findVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		try {
			return vehiclePOToVO(vehicleData.findVehicle(vehicleid));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		try {
			return vehicleData.deleteVehicle(vehicleid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyVehicle(VehicleVO vehicleVO) {
		// TODO Auto-generated method stub
		try {
			return vehicleData.modifyVehicle(vehicleVOToPO(vehicleVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	private VehiclePO vehicleVOToPO(VehicleVO vehicleVO){
		return new VehiclePO(vehicleVO.getVehicleid(),vehicleVO.getNumber(),vehicleVO.getAge());
	}
	private VehicleVO vehiclePOToVO(VehiclePO vehiclePO){
		return new VehicleVO(vehiclePO.getVehicleid(),vehiclePO.getNumber(),vehiclePO.getAge());
	}

}
