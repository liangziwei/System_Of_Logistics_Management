package businessLogicService.businessBLService;

import vo.businessVO.VehicleVO;

public interface VehicleBLService {
     
	public boolean addVehicle(VehicleVO vehicleVO);
     
    public VehicleVO findVehicle(int vehicleid);
    
    public boolean deleteVehicle(int vehicleid);
    
    public boolean modifyVehicle(VehicleVO vehicleVO);
}
