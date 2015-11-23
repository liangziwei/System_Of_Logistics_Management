package businessLogic.businessLogicController.businessController;

import vo.businessVO.DriverVO;
import businessLogic.businessLogicModel.businessModel.Driver;
import businessLogicService.businessBLService.DriverBLService;

public class DriverController implements DriverBLService {

	private Driver driver=new Driver();
	
	public boolean addDriver(DriverVO driverVO) {
		// TODO Auto-generated method stub
		return driver.addDriver(driverVO);
	}

	public DriverVO findDriver(String driverid) {
		// TODO Auto-generated method stub
		return driver.findDriver(driverid);
	}

	public boolean deleteDriver(String driverid) {
		// TODO Auto-generated method stub
		return driver.deleteDriver(driverid);
	}

	public boolean modifyDriver(DriverVO driverVO) {
		// TODO Auto-generated method stub
		return driver.modifyDriver(driverVO);
	}

}
