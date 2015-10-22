package dataService.businessDataService;

import po.businessPO.DriverPO;

public interface DriverDataService {
	 
		public boolean addDriver(DriverPO driverPO);
	    
	    public DriverPO findDriver(int driverid);
	    
	    public boolean deleteDriver(int driverid);
	    
	    public boolean modifyDriver(DriverPO driverPO);

}
