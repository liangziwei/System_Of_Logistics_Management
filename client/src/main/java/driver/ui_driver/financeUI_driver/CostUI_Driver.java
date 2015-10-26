package driver.ui_driver.financeUI_driver;

import java.util.Scanner;

import stub.businessLogicImpl_stub.financeBLImpl_stub.CostBLImpl_Stub;
import vo.financeVO.PaymentVO;
import businessLogicService.financeBLService.CostBLService;

public class CostUI_Driver {
	public static void main(String[] args) {
		CostBLService cost = new CostBLImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go){
			System.out.println("请输入请求：（1）新建付款单（2）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				System.out.println("添加是否成功："+cost.addPayment(new 
						PaymentVO(null,0.0,null,null,null,null)));
				break;
			case 2:
				go = false;
				break;
			}
		}
		s.close();
	}

}
