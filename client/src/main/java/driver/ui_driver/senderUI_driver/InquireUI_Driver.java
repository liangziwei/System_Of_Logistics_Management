package driver.ui_driver.senderUI_driver;

import java.util.List;
import java.util.Scanner;

import businessLogicService.senderBLService.InquireBLService;
import constant.City;
import stub.businessLogicImpl_stub.senderBLImpl_stub.InquireBLImpl_Stub;
import vo.senderVO.LogisticsVO;

public class InquireUI_Driver {

	public static void main(String[] args) {
		InquireBLService inquire = new InquireBLImpl_Stub();
		Scanner s = new Scanner(System.in);
		boolean go = true;
		while(go) {
			System.out.println("请输入要进行的操作：（1）查询物流信息（2）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				LogisticsVO logistics = inquire.getLogInfoById("0000000000");
				System.out.println("货物现在所处的物流节点为： " + logistics.getState());
				List<City> trace = logistics.getTrace();
				System.out.println("货物运送的物流轨迹为：");
				for(int i = 0; i < trace.size() - 1; i++) {
					System.out.print(trace.get(i) + " --> ");
				}
				System.out.println(trace.get(trace.size() - 1));
				break;
			case 2:
				go = false;
				break;
			}
		}
		s.close();
	}
}
