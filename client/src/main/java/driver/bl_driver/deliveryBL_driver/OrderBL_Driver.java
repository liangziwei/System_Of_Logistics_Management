package driver.bl_driver.deliveryBL_driver;

import java.util.List;
import java.util.Scanner;

import constant.City;
import dataService.deliveryDataService.OrderDataService;
import driver.ui_driver.deliveryUI_driver.OrderUI_Driver;
import po.deliveryPO.OrderPO;
import po.deliveryPO.TimeRecordPO;
import stub.dataImpl_stub.deliveryDataImpl_stub.OrderDataImpl_Stub;

public class OrderBL_Driver {

	public static void main(String[] args) {
		OrderDataService order = new OrderDataImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("输入要进行的操作:（1）查询订单（2）保存订单（3）查询时间记录（4）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				OrderPO orderInfo = order.getOrderInfoById("0000000000");
				showOrderInfo(orderInfo);
				break;
			case 2:
				System.out.println("是否保存成功： " + order.saveOrderInfo(null));
				break;
			case 3:
				List<TimeRecordPO> time = order.getTimeRecords(City.NAN_JING, City.BEI_JING);
				showTimeRecord(time);
				break;
			case 4:
				go = false;
				break;
			}
		}
		s.close();
	}
	
	private static void showOrderInfo(OrderPO orderInfo) {
		OrderUI_Driver.showClientInfo(orderInfo.getSenderInfo());
		OrderUI_Driver.showClientInfo(orderInfo.getReceiverInfo());
		OrderUI_Driver.showGoodsInfo(orderInfo.getGoodsInfo());
	}
	
	private static void showTimeRecord(List<TimeRecordPO> timeRecord) {
		System.out.println("所有时间记录如下：");
		for(int i = 0; i < timeRecord.size(); i++) {
			System.out.println("出发地：" + timeRecord.get(i).getSource()
					+ "  目的地： " + timeRecord.get(i).getDestination()
					+ "  时间： " + timeRecord.get(i).getTime() + "天");
		}
	}
}
