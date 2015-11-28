package businessLogic.businessLogicModel.businessModel;

import network.RMI;
import po.businessPO.VehiclePO;
import stub.dataImpl_stub.businessDataImpl_stub.VehicleDataImpl_Stub;
import vo.businessVO.VehicleVO;
import dataService.businessDataService.VehicleDataService;

public class Vehicle {

    private VehicleDataService vehicleData=new VehicleDataImpl_Stub();
//	private VehicleDataService vehicleData=RMI.<VehicleDataService>getDataService("vehicle");
    
	public boolean addVehicle(VehicleVO vehicleVO) {
		// TODO Auto-generated method stub
		
		return vehicleData.addVehicle(vehicleVOToPO(vehicleVO));
	}

	public VehicleVO findVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return vehiclePOToVO(vehicleData.findVehicle(vehicleid));
	}

	public boolean deleteVehicle(String vehicleid) {
		// TODO Auto-generated method stub
		return vehicleData.deleteVehicle(vehicleid);
	}

	public boolean modifyVehicle(VehicleVO vehicleVO) {
		// TODO Auto-generated method stub
		return vehicleData.modifyVehicle(vehicleVOToPO(vehicleVO));
	}
	private VehiclePO vehicleVOToPO(VehicleVO vehicleVO){
		return new VehiclePO(vehicleVO.getVehicleid(),vehicleVO.getNumber(),vehicleVO.getAge());
	}
	private VehicleVO vehiclePOToVO(VehiclePO vehiclePO){
		return new VehicleVO(vehiclePO.getVehicleid(),vehiclePO.getNumber(),vehiclePO.getAge());
	}
}
