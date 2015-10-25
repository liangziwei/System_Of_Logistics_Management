package driver.ui_driver.businesssUI_driver;

import stub.businessLogicImpl_stub.businessBLImpl_stub.EntruckingBLImpl_Stub;
import vo.businessVO.EntruckingVO;
import businessLogicService.businessBLService.EntruckingBLService;

public class EntruckingUI_Driver {
	
	public void driver() {
		EntruckingBLService entrucking=new EntruckingBLImpl_Stub();
		EntruckingVO entruckingVO=new EntruckingVO("2015-10-10","025001","0250012015101012345","025002","025001001","监装员","押运员",600);
		if(entrucking.addEntruckingFrom(entruckingVO)){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	} 
}
