package driver.ui_driver.businesssUI_driver;

import stub.businessLogicImpl_stub.businessBLImpl_stub.DriverBLImpl_Stub;
import vo.businessVO.DriverVO;
import businessLogicService.businessBLService.DriverBLService;

public class DriverUI_Driver {
	private DriverBLService driverBL=new DriverBLImpl_Stub();
	private DriverVO driverVO;
	public void driver(){
		driverVO=new DriverVO("025002011","doge","1997-11-11","111111111111111","12345098761","男","1");
		if(driverBL.addDriver(new DriverVO("025002011","doge","1997-11-11","111111111111111","12345098761","男","1"))){
			System.out.println("司机信息添加成功");
		}else{
			System.out.println("司机信息添加失败");
		}
		
		driverVO=driverBL.findDriver("111111111");	
		System.out.println(driverVO.getDriverid()+" "+driverVO.getName() );
		
		if(driverBL.deleteDriver("111111111")){
			System.out.println("司机信息删除成功");
		}else{
			System.out.println("司机信息删除失败");
		}
		if(driverBL.modifyDriver(driverVO)){
			System.out.println("司机信息修改成功");
		}else{
			System.out.println("司机信息修改失败");
		}
	}
	
}
