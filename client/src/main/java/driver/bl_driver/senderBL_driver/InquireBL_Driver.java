package driver.bl_driver.senderBL_driver;

import java.util.List;
import java.util.Scanner;

import constant.City;
import constant.TransitionNode;
import dataService.senderDataService.InquireDataService.InquireDataService;
import po.senderPO.LogisticsPO;
import stub.dataImpl_stub.senderDataImpl_stub.InquireDataImpl_Stub;

public class InquireBL_Driver {

	public static void main(String[] args) {
		InquireDataService inquire = new InquireDataImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("输入要进行的操作：（1）查询物流信息（2）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				showLogistics(inquire);
				break;
			case 2:
				go = false;
				break;
			}
		}
		s.close();
	}
	
	private static void showLogistics(InquireDataService inquire) {
		LogisticsPO logistics = inquire.getLogInfoById("0000000000");
		TransitionNode node = logistics.getState();
		System.out.println("快递的物流状态： " + node);
		List<City> trace = logistics.getTrace();
		System.out.print("快递的货运轨迹： ");
		for(int i = 0; i < trace.size() - 1; i++) {
			System.out.print(trace.get(i) + " --> ");
		}
		System.out.println(trace.get(trace.size() - 1));
	}
}
