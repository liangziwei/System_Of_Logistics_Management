package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import network.RMI;
import po.businessPO.VehiclePO;
import vo.businessVO.VehicleVO;
import dataService.businessDataService.VehicleDataService;

public class Vehicle {

//    private VehicleDataService vehicleData=new VehicleDataImpl_Stub();
	private VehicleDataService vehicleData=RMI.<VehicleDataService>getDataService("vehicle");
    
	public boolean addVehicle(VehicleVO vehicleVO) {
		// TODO Auto-generated method stub
		
		try {
			return vehicleData.addVehicle(vehicleVO.vehicleVOToPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("RMI连接出错");
			return false;
		}
	}

	public VehicleVO findVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		VehiclePO vehiclePO = null;
		try {
			vehiclePO = vehicleData.findVehicle(vehicleid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("RMI连接出错");
		}
		return vehiclePO.vehiclePOToVO();
	}

	public boolean deleteVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		try {
			return vehicleData.deleteVehicle(vehicleid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("RMI连接出错");
			return false;
		}
	}

	public boolean modifyVehicle(VehicleVO vehicleVO) {
		// TODO Auto-generated method stub
		try {
			return vehicleData.modifyVehicle(vehicleVO.vehicleVOToPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("RMI连接出错");
			return false;
		}
	}
	
}
