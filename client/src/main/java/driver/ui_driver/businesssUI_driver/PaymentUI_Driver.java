package driver.ui_driver.businesssUI_driver;

import java.util.ArrayList;

import stub.businessLogicImpl_stub.businessBLImpl_stub.PaymentBLImpl_Stub;
import vo.businessVO.ReceivableVO;
import businessLogicService.businessBLService.PaymentBLService;

public class PaymentUI_Driver {

	ArrayList<String> deliveryid=new ArrayList<String>();
	public void driver(){
		deliveryid.add("1234567890");
		deliveryid.add("0987654321");
		PaymentBLService payment=new PaymentBLImpl_Stub();
		ReceivableVO receivableVO=new ReceivableVO("2015-10-10",33,"快递员1",deliveryid);
		if(payment.addPayentForm(receivableVO)){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
}
