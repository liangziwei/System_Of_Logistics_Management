package driver.ui_driver.deliveryUI_driver;

import java.util.Scanner;

import businessLogicService.deliveryBLService.ReceiptBLService;
import stub.businessLogicImpl_stub.deliveryBLImpl_stub.ReceiptBLImpl_Stub;
import vo.deliveryVO.ReceiptVO;

public class ReceiptUI_Driver {

	public static void main(String[] args) {
		ReceiptBLService receipt = new ReceiptBLImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("输入要进行的操作：（1）保存订单信息（2）更新时间历史记录（3）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				System.out.println("订单是否保存成功：" 
			+ receipt.saveReceiptInfo(new ReceiptVO(null, null, null)));
				break;
			case 2:
				System.out.println("时间历史记录是否更新成功: " 
			+ receipt.updateTimeRecord("小白", "2015-10-23", "0000000000"));
				break;
			case 3:
				go = false;
				break;
			}
		}		
		s.close();
	}
}
