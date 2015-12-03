package driver.ui_driver.managerUI_driver;

import java.util.Scanner;

import stub.businessLogicImpl_stub.managerBLImpl_stub.ApprovalFormBLImpl_Stub;
import businessLogicService.managerBLService.ApprovalFormBLService;

public class ApprovalFormUI_Driver {
	public static void main(String[] args) {
		ApprovalFormBLService approval = new ApprovalFormBLImpl_Stub();
		boolean go=true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("请输入请求：（1）获得所有未审批单据（2）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
//				System.out.println("所有未审批单据："+approval.getUncheckedForms("2015-02-14"));
				break;
			case 2:
				go = false;
				break;
			}
		}
		s.close();
	}
}
