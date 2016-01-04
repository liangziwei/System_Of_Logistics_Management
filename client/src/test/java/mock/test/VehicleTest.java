package mock.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.businessVO.VehicleVO;
import businessLogic.businessLogicController.businessController.VehicleController;

public class VehicleTest {
	@Test
	
	public void testaddVehicle(){
		VehicleController vehicleControl=new VehicleController();
		VehicleVO vehicleVO=new VehicleVO("025001001","苏A 00001","2");
		assertEquals(true,vehicleControl.addVehicle(vehicleVO));
	}
	@Test
	public void testfindVehicle(){
		VehicleController vehicleControl=new VehicleController();
		assertEquals("025001001",vehicleControl.findVehicle("025001001").getVehicleid());
		assertEquals(null,vehicleControl.findVehicle("025001001").getNumber());
		assertEquals(null,vehicleControl.findVehicle("025001001").getAge());
	}
	@Test
	public void testdeleteVehicle(){
		VehicleController vehicleControl=new VehicleController();
		assertEquals(true,vehicleControl.deleteVehicle("025001001"));
	}
	@Test
	public void testmodifyVehicle(){
		VehicleController vehicleControl=new VehicleController();
		VehicleVO vehicleVO=new VehicleVO("025001002","苏A 00011","2");
		assertEquals(false,vehicleControl.addVehicle(vehicleVO));
	}
}