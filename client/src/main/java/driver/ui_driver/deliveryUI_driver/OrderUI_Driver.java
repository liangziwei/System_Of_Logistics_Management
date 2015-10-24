package driver.ui_driver.deliveryUI_driver;

import java.util.Scanner;

import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.ClientType;
import constant.DeliveryType;
import stub.businessLogicImpl_stub.deliveryBLImpl_stub.OrderBLImpl_Stub;
import vo.deliveryVO.ClientInfo;
import vo.deliveryVO.GoodsInfo;
import vo.deliveryVO.OrderVO;

public class OrderUI_Driver {

	public static void main(String[] args) {
		OrderBLService order = new OrderBLImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("请输入请求:(1)查询订单（2）输入订单"
					+ "（3）计算时间 （4）计算报价（5）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				OrderVO info = order.getOrderInfoById("0000000000");
				GoodsInfo goods = info.getGoodsInfo();
				ClientInfo receiver =  info.getReceiverInfo();
				ClientInfo sender = info.getSenderInfo();
				showClientInfo(sender);
				showClientInfo(receiver);
				showGoodsInfo(goods);
				break;
			case 2:
				System.out.println("保存是否成功： "
						+ order.saveOrderInfo(null));
				break;
			case 3:
				System.out.println("快递送达需要：" 
			+ order.calculateTime(City.NAN_JING, City.BEI_JING) + "天");
				break;
			case 4:
				System.out.println("快递预估费用："
				+ order.calculatePrice(DeliveryType.ECONOMIC, 20, City.NAN_JING, City.BEI_JING) + "元");
				break;
			case 5:
				go = false;
				break;
			}
		}
		s.close();
	}
	
	public static void showClientInfo(ClientInfo client) {
		if(client.getIdentity() == ClientType.SENDER)
			System.out.println("寄件人信息：");
		else
			System.out.println("收件人信息：");
		System.out.println("姓名：" + client.getName());
		System.out.println("地址: " + client.getAddress());
		System.out.println("单位: " + client.getCompany());
		System.out.println("电话：" + client.getPhoneNumber());
		System.out.println("手机：" + client.getMobileNumber());
	}
	
	public static void showGoodsInfo(GoodsInfo goods) {
		System.out.println("货物信息：");
		System.out.println("重量：" + goods.getWeight());
		System.out.println("物品名称 ：");
		for(int i = 0; i < goods.getNames().size(); i++) {
			System.out.print(goods.getNames().get(i) + " ");
		}
		System.out.println();
		System.out.println("尺寸：" + goods.getSize());
		System.out.println("包装类型：" + goods.getPackageType());
		System.out.println("快递类型：" + goods.getDeliveryType());
		System.out.println("订单条形码号：" + goods.getId());
		System.out.println("订单创建日期：" + goods.getDate());
		System.out.println("货物经过站点：");
		for(int i = 0; i < goods.getTransitNode().size() - 1; i++)
			System.out.print(goods.getTransitNode().get(i) + " --> ");
		System.out.println(goods.getTransitNode().get(goods.getTransitNode().size() - 1));
	}
}
