package mock.object;

import po.businessPO.VehiclePO;
import dataService.businessDataService.VehicleDataService;

public class MockVehicleData implements VehicleDataService {
	
	private VehiclePO vehiclePO=new VehiclePO("025001001","苏A 00001","2");

	public boolean addVehicle(VehiclePO vehiclePO) {
		// TODO Auto-generated method stub
		this.vehiclePO=vehiclePO;
		return true;
	}

	public VehiclePO findVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return vehiclePO;
	}

	public boolean deleteVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean modifyVehicle(VehiclePO vehiclePO) {
		// TODO Auto-generated method stub
		this.vehiclePO=vehiclePO;
		return true;
	}

}
