package network;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dataImpl.NetworkTestImpl;
import dataImpl.administratorDataImpl.AdministratorDataImpl;
import dataImpl.businessDataImpl.DriverDataImpl;
import dataImpl.businessDataImpl.EntruckingDataImpl;
import dataImpl.businessDataImpl.PaymentDataImpl;
import dataImpl.businessDataImpl.ReceiveAndSendDataImpl;
import dataImpl.businessDataImpl.VehicleDataImpl;
import dataImpl.deliveryDataImpl.OrderDataImpl;
import dataImpl.deliveryDataImpl.ReceiptDataImpl;
import dataImpl.financeDataImpl.AccountDataImpl;
import dataImpl.financeDataImpl.CostDataImpl;
import dataImpl.financeDataImpl.OriginalInfoDataImpl;
import dataImpl.financeDataImpl.SettlementDataImpl;
import dataImpl.financeDataImpl.StatisticsDataImpl;
import dataImpl.managerDataImpl.ApprovalFormDataImpl;
import dataImpl.managerDataImpl.MakeConstantDataImpl;
import dataImpl.managerDataImpl.OrganizationManagementDataImpl;
import dataImpl.managerDataImpl.StaffManagementDataImpl;
import dataImpl.repositoryDataImpl.InRepositoryDataImpl;
import dataImpl.repositoryDataImpl.ManageRepositoryDataImpl;
import dataImpl.repositoryDataImpl.OutRepositoryDataImpl;
import dataImpl.senderDataImpl.InquireDataImpl;
import dataImpl.transitionDataImpl.LoadingDataImpl;
import dataImpl.transitionDataImpl.ReceivingDataImpl;
import dataImpl.transitionDataImpl.TransferringDataImpl;

public class RMI {
	/**
	 *远程服务注册对象 
	 */
	private static Registry REGISTRY = null;
	
	/**
	 *远程服务对象列表 
	 */
	private static List<RemoteObjectMap> REMOTE_MAP_LIST = new ArrayList<RemoteObjectMap>();
	
	static {
		try {
			REGISTRY = LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//收件人
		REMOTE_MAP_LIST.add(new RemoteObjectMap("inquire", new InquireDataImpl()));
		//寄件人
		REMOTE_MAP_LIST.add(new RemoteObjectMap("order", new OrderDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("receipt", new ReceiptDataImpl()));
		//营业厅业务员
		REMOTE_MAP_LIST.add(new RemoteObjectMap("entrucking", new EntruckingDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("receivable", new PaymentDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("receiveAndSend", new ReceiveAndSendDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("vehicle", new VehicleDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("driver", new DriverDataImpl()));
		//中转中心仓库管理人员
		REMOTE_MAP_LIST.add(new RemoteObjectMap("inrepository", new InRepositoryDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("outrepository", new OutRepositoryDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("manage", new ManageRepositoryDataImpl()));
		//中转中心业务员
		REMOTE_MAP_LIST.add(new RemoteObjectMap("loading", new LoadingDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("receiving", new ReceivingDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("transferring", new TransferringDataImpl()));
		//总经理
		REMOTE_MAP_LIST.add(new RemoteObjectMap("approvalForm", new ApprovalFormDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("makeConstant", new MakeConstantDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("organization", new OrganizationManagementDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("staff", new StaffManagementDataImpl()));
		//财务人员
		REMOTE_MAP_LIST.add(new RemoteObjectMap("account", new AccountDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("cost", new CostDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("originalInfo", new OriginalInfoDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("settlement", new SettlementDataImpl()));
		REMOTE_MAP_LIST.add(new RemoteObjectMap("statistics", new StatisticsDataImpl()));
		//系统管理人员
		REMOTE_MAP_LIST.add(new RemoteObjectMap("administrator", new AdministratorDataImpl()));
		//网络连接测试
		REMOTE_MAP_LIST.add(new RemoteObjectMap("test", new NetworkTestImpl()));
	}

	public static void initRMI() throws RemoteException, AlreadyBoundException {
		for (RemoteObjectMap map : REMOTE_MAP_LIST) {
			bind(map.getService(), map.getKey());
		}
		//提示服务器运行成功
		System.out.println("Server is working...");
	}
	
	/**
	 * 将远程服务对象与相应字符串绑定
	 * @param implementation， 远程服务接口的具体实现对象
	 * @param key， 远程服务对象对应的关键字
	 * @throws RemoteException 
	 * @throws AlreadyBoundException 
	 */
	private static<Service extends Remote> void bind(Service implementation, String key) throws RemoteException, AlreadyBoundException {
		@SuppressWarnings("unchecked")
		Service stub = (Service) UnicastRemoteObject.exportObject(implementation, 0);
		REGISTRY.bind(key, stub);
	}
}

/**
 * 远程服务对象映射，包含远程服务对象与对应的关键字
 */
class RemoteObjectMap {
	
	private String key;
	
	private Remote service;
	
	public RemoteObjectMap(String key, Remote service) {
		this.key = key;
		this.service = service;
	}
	
	/**
	 *获得与对象绑定的关键字 
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 *获得远程服务对象 
	 */
	public Remote getService() {
		return this.service;
	}
}
