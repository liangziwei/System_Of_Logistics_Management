package stub.dataImpl_stub.businessDataImpl_stub;

import po.businessPO.VehiclePO;
import dataService.businessDataService.VehicleDataService;

public class VehicleDataImpl_Stub implements VehicleDataService {

	public boolean addVehicle(VehiclePO vehiclePO) {
		// TODO Auto-generated method stub
		return false;
	}

	public VehiclePO findVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return new VehiclePO("025001001","苏A 00001","2");
	}

	public boolean deleteVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyVehicle(VehiclePO vehiclePO) {
		// TODO Auto-generated method stub
		return false;
	}

}
