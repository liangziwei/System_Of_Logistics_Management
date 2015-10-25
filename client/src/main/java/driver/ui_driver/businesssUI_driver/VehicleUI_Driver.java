package driver.ui_driver.businesssUI_driver;

import stub.businessLogicImpl_stub.businessBLImpl_stub.VehicleBLImpl_Stub;
import vo.businessVO.VehicleVO;
import businessLogicService.businessBLService.VehicleBLService;

public class VehicleUI_Driver {

	private VehicleBLService vehicleBL=new VehicleBLImpl_Stub();
	private VehicleVO vehicleVO;
	public void driver(){
		vehicleVO=new VehicleVO("025002011","苏A 02138","1");
		if(vehicleBL.addVehicle(new VehicleVO("025002011","苏A 02138","1"))){
			System.out.println("车辆信息添加成功");
		}else{
			System.out.println("车辆信息添加失败");
		}
		
		vehicleVO=vehicleBL.findVehicle("111111111");	
		System.out.println(vehicleVO.getVehicleid()+" "+vehicleVO.getNumber()+" "+vehicleVO.getAge() );
		
		if(vehicleBL.deleteVehicle("111111111")){
			System.out.println("车辆信息删除成功");
		}else{
			System.out.println("车辆信息删除失败");
		}
		if(vehicleBL.modifyVehicle(vehicleVO)){
			System.out.println("车辆信息修改成功");
		}else{
			System.out.println("车辆信息修改失败");
		}
	}
}
