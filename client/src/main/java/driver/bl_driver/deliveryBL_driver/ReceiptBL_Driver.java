package driver.bl_driver.deliveryBL_driver;

import java.util.Scanner;

import constant.City;
import dataService.deliveryDataService.ReceiptDataService;
import stub.dataImpl_stub.deliveryDataImpl_stub.ReceiptDataImpl_Stub;

public class ReceiptBL_Driver {

	public static void main(String[] args) {
		ReceiptDataService receipt = new ReceiptDataImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("输入要进行的操作：（1）保存收件信息（2）更新时间记录（3）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				System.out.println("是否保存收件信息成功： " + receipt.saveReceiptInfo(null));
				break;
			case 2:
				System.out.println("是否已经更新时间历史记录：" + 
			receipt.updateTimeRecord(2, City.NAN_JING, City.BEI_JING));
				break;
			case 3:
				go = false;
				break;
			}
		}
		s.close();
	}
}
