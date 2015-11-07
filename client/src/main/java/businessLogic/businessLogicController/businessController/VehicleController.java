package businessLogic.businessLogicController.businessController;

import vo.businessVO.VehicleVO;
import businessLogic.businessLogicModel.businessModel.Vehicle;
import businessLogicService.businessBLService.VehicleBLService;

public class VehicleController implements VehicleBLService {
	
	private Vehicle vehicle=new Vehicle();

	public boolean addVehicle(VehicleVO vehicleVO) {
		// TODO Auto-generated method stub
		return vehicle.addVehicle(vehicleVO);
	}

	public VehicleVO findVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return vehicle.findVehicle(vehicleid);
	}

	public boolean deleteVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return vehicle.deleteVehicle(vehicleid);
	}

	public boolean modifyVehicle(VehicleVO vehicleVO) {
		// TODO Auto-generated method stub
		return vehicle.modifyVehicle(vehicleVO);
	}

}
