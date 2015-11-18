package main;

import network.RMI;
import ui.mainui.ExpressFrame;
import ui.mainui.ExpressPanel;
import ui.viewcontroller.ViewController;

public class Start {

//	public static void main(String[] args) {
//		System.out.println("请输入订单条形码号：");
//		OrderBLService order = new OrderController();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			String id = reader.readLine();
//			OrderVO orderInfo = order.getOrderInfoById(id);
//			System.out.println("以下是订单信息：");
//			System.out.println("=======================");
//			showClientInfo(orderInfo.getSenderInfo());
//			System.out.println("=======================");
//			showClientInfo(orderInfo.getReceiverInfo());
//			System.out.println("=======================");
//			showGoodsInfo(orderInfo.getGoodsInfo());
//			System.out.println("=======================");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void showClientInfo(ClientInfo client) {
//		if(client.getIdentity() == ClientType.SENDER)
//			System.out.println("寄件人信息：");
//		else
//			System.out.println("收件人信息：");
//		System.out.println("姓名：" + client.getName());
//		System.out.println("地址: " + client.getAddress());
//		System.out.println("单位: " + client.getCompany());
//		System.out.println("电话：" + client.getPhoneNumber());
//		System.out.println("手机：" + client.getMobileNumber());
//	}
//	
//	public static void showGoodsInfo(GoodsInfo goods) {
//		System.out.println("货物信息：");
//		System.out.println("重量：" + goods.getWeight());
//		System.out.println("物品名称 ：" + goods.getName());
//		System.out.println();
//		System.out.println("尺寸：" + goods.getSize());
//		System.out.println("包装类型：" + goods.getPackageType());
//		System.out.println("快递类型：" + goods.getDeliveryType());
//		System.out.println("订单条形码号：" + goods.getId());
//		System.out.println("订单创建日期：" + goods.getDate());
//		System.out.println("货物经过站点：");
//		for(int i = 0; i < goods.getTransitNode().size() - 1; i++)
//			System.out.print(goods.getTransitNode().get(i) + " --> ");
//		System.out.println(goods.getTransitNode().get(goods.getTransitNode().size() - 1));
//	}
	
	public static void main(String[] args) {
		
		//主框架
		ExpressFrame frame = new ExpressFrame();
		//界面跳转控制器
		ViewController controller = new ViewController(frame);
		//主面板
		ExpressPanel panel = new ExpressPanel(controller);
		//主框架添加主面板
		frame.add(panel);
		new RMI();
	}
}
