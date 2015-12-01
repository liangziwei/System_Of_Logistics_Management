package driver.ui_driver.businesssUI_driver;

import stub.businessLogicImpl_stub.businessBLImpl_stub.ReceiveAndSendBLImpl_Stub;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;
import businessLogicService.businessBLService.ReceiveAndSendBLService;
import constant.CargoState;

public class ReceiveAndSendUI_Driver {

	public void driver(){
		ReceiveAndSendBLService receiveAndSend=new ReceiveAndSendBLImpl_Stub();
		ArrivalFormVO arrivalFormVO=new ArrivalFormVO("2015-10-10","0250","025002",CargoState.完整);
		SendFormVO sendFormVO=new SendFormVO("2015-10-12","1234567890","派送员1");
		if(receiveAndSend.addReceiveFrom(arrivalFormVO)){
			System.out.println("到达单添加成功");
		}else{
			System.out.println("到达单添加失败");
		}
		if(receiveAndSend.addSendFrom(sendFormVO)){
			System.out.println("派件单添加成功");
		}else{
			System.out.println("派件单添加失败");
		}
	}
}
