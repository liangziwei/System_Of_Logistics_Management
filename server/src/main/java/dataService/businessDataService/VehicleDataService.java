package dataService.businessDataService;

import po.businessPO.VehiclePO;

public interface VehicleDataService {
	
	public boolean addVehicle(VehiclePO vehiclePO);
    
    public VehiclePO findVehicle(int vehicleid);
    
    public boolean deleteVehicle(int vehicleid);
    
    public boolean modifyVehicle(VehiclePO vehiclePO);
}
