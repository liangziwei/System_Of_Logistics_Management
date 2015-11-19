package network;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import stub.dataImpl_stub.administratorDataImpl_stub.AdministratorDataImpl_Stub;
import dataImpl.administratorDataImpl.AdministratorDataImpl;
import dataImpl.businessDataImpl.EntruckingDataImpl;
import dataImpl.deliveryDataImpl.OrderDataImpl;
import dataImpl.deliveryDataImpl.ReceiptDataImpl;
import dataImpl.senderDataImpl.InquireDataImpl;
import dataService.administratorDataService.AdministratorDataService;
import dataService.businessDataService.EntruckingDataService;
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

		try {
			EntruckingDataService entrucking=new EntruckingDataImpl();
			EntruckingDataService entrucking_stub=(EntruckingDataService)UnicastRemoteObject.exportObject(entrucking, 0);
			registry.bind("entrucking", entrucking_stub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
		try {
//			AdministratorDataService administrator=new AdministratorDataImpl();
			AdministratorDataService administrator=new AdministratorDataImpl_Stub();
			AdministratorDataService administrator_stub=(AdministratorDataService)UnicastRemoteObject.exportObject(administrator, 0);
			registry.bind("administrator", administrator_stub);
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
