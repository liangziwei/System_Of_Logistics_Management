package network;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import dataImpl.deliveryDataImpl.OrderDataImpl;
import dataImpl.deliveryDataImpl.ReceiptDataImpl;
import dataImpl.senderDataImpl.InquireDataImpl;
import dataService.deliveryDataService.OrderDataService;
import dataService.deliveryDataService.ReceiptDataService;
import dataService.senderDataService.InquireDataService;

public class RMI {
	
	private static Registry registry = null;
	
	static {
		try {
			registry = LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void initRMI() {
		//初始化寄件人的RMI连接
		initSenderRMI();
		//初始化快递员的RMI连接
		initDeliveryRMI();
		//初始化营业厅业务员的RMI连接
		initBusinessRMI();
		//初始化中装中心库存管理人员的RMI连接
		initRepositoryRMI();
		//初始化中转中心业务员的RMI连接
		initTransitionRMI();
		//初始化总经理的RMI连接
		initManagerRMI();
		//初始化财务人员的RMI连接
		initFinanceRMI();
		//初始化系统管理人员的RMI连接
		initAdministratorRMI();
		//提示服务器运行成功
		System.out.println("Server is working...");
	}

	private static void initSenderRMI() {
		try {
			//物流信息访问接口
			InquireDataService inquire = new InquireDataImpl();
			InquireDataService stub = (InquireDataService) UnicastRemoteObject.exportObject(inquire, 0);
			registry.bind("inquire", stub);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initDeliveryRMI() {
		try {
			//订单数据访问接口
			OrderDataService order = new OrderDataImpl();
			OrderDataService order_stub = (OrderDataService) UnicastRemoteObject.exportObject(order, 0);
			registry.bind("order", order_stub);
			//收件信息数据访问接口
			ReceiptDataService receipt = new ReceiptDataImpl();
			ReceiptDataService receipt_stub = (ReceiptDataService) UnicastRemoteObject.exportObject(receipt, 0);
			registry.bind("receipt", receipt_stub);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void initBusinessRMI() {

	}
	
	private static void initRepositoryRMI() {

	}
	
	private static void initTransitionRMI() {

	}
	
	private static void initManagerRMI() {

	}
	
	private static void initFinanceRMI() {

	}
	
	private static void initAdministratorRMI() {

	}

}
