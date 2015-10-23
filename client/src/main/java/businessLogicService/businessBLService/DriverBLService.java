package businessLogicService.businessBLService;

import vo.businessVO.DriverVO;

public interface DriverBLService {
	public boolean addDriver(DriverVO driverVO);
    
    public DriverVO findDriver(int driverid);
    
    public boolean deleteDriver(int driverid);
    
    public boolean modifyDriver(DriverVO driverVO);
}
