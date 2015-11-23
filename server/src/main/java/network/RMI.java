package network;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import stub.dataImpl_stub.administratorDataImpl_stub.AdministratorDataImpl_Stub;
import stub.dataImpl_stub.businessDataImpl_stub.EntruckingDataImpl_Stub;
import stub.dataImpl_stub.businessDataImpl_stub.PaymentDataImpl_Stub;
import dataImpl.businessDataImpl.EntruckingDataImpl;
import dataImpl.businessDataImpl.PaymentDataImpl;
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
import dataImpl.senderDataImpl.InquireDataImpl;
import dataService.administratorDataService.AdministratorDataService;
import dataService.businessDataService.EntruckingDataService;
import dataService.businessDataService.PaymentDataService;
import dataService.deliveryDataService.OrderDataService;
import dataService.deliveryDataService.ReceiptDataService;
import dataService.financeDataService.AccountDataService;
import dataService.financeDataService.CostDataService;
import dataService.financeDataService.OriginalInfoDataService;
import dataService.financeDataService.SettlementDataService;
import dataService.financeDataService.StatisticsDataService;
import dataService.managerDataService.ApprovalFormDataService;
import dataService.managerDataService.MakeConstantDataService;
import dataService.managerDataService.OrganizationManagementDataService;
import dataService.managerDataService.StaffManagementDataService;
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
//			EntruckingDataService entrucking = new EntruckingDataImpl();
			EntruckingDataService entrucking = new EntruckingDataImpl_Stub();
			InquireDataService entrucking_stub = (InquireDataService) UnicastRemoteObject.exportObject(entrucking, 0);
			registry.bind("entrucking", entrucking_stub);
			
//			PaymentDataService payment = new PaymentDataImpl();
			PaymentDataService payment = new PaymentDataImpl_Stub();
			InquireDataService payment_stub = (InquireDataService) UnicastRemoteObject.exportObject(payment, 0);
			registry.bind("receivable", entrucking_stub);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void initRepositoryRMI() {

	}
	
	private static void initTransitionRMI() {

	}
	
	private static void initManagerRMI() {
		try{
			//审批单据访问接口
			ApprovalFormDataService approvalForm = new ApprovalFormDataImpl();
			ApprovalFormDataService approvalForm_stub = (ApprovalFormDataService) UnicastRemoteObject.exportObject(approvalForm, 0);
			registry.bind("approvalForm", approvalForm_stub);
			//城市距离和价格常量访问接口
			MakeConstantDataService makeConstant = new MakeConstantDataImpl();
			MakeConstantDataService makeConstant_stub = (MakeConstantDataService)UnicastRemoteObject.exportObject(makeConstant, 0);
			registry.bind("makeConstant", makeConstant_stub);
			//机构信息访问接口
			OrganizationManagementDataService organization = new OrganizationManagementDataImpl();
			OrganizationManagementDataService organization_stub = (OrganizationManagementDataService)UnicastRemoteObject.exportObject(organization, 0);
			registry.bind("organization", organization_stub);
			//人员信息访问接口
			StaffManagementDataService staff = new StaffManagementDataImpl();
			StaffManagementDataService staff_stub = (StaffManagementDataService) UnicastRemoteObject.exportObject(staff, 0);
			registry.bind("staff", staff_stub);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	private static void initFinanceRMI() {
		try{
			//账号信息访问接口
			AccountDataService account = new AccountDataImpl();
			AccountDataService account_stub = (AccountDataService) UnicastRemoteObject.exportObject(account, 0);
			registry.bind("account", account_stub);
			//成本信息访问接口
			CostDataService cost = new CostDataImpl();
			CostDataService cost_stub = (CostDataService) UnicastRemoteObject.exportObject(cost, 0);
			registry.bind("cost", cost_stub);
			//期初建账访问接口
			OriginalInfoDataService originalInfo = new OriginalInfoDataImpl();
			OriginalInfoDataService originalInfo_stub =
					(OriginalInfoDataService) UnicastRemoteObject.exportObject(originalInfo, 0);
			registry.bind("originalInfo", originalInfo_stub);
			//结算管理访问接口
			SettlementDataService settlement = new SettlementDataImpl();
			SettlementDataService settlement_stub = (SettlementDataService) UnicastRemoteObject.exportObject(settlement, 0);
			registry.bind("settlement", settlement_stub);
			//统计分析访问接口
			StatisticsDataService statistics = new StatisticsDataImpl();
			StatisticsDataService statistics_stub = (StatisticsDataService) UnicastRemoteObject.exportObject(statistics, 0);
			registry.bind("statistics", statistics_stub);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void initAdministratorRMI() {
		try {
			//用户信息访问接口
//			AdministratorDataService admin = new AdministratorDataImpl();
			AdministratorDataService admin = new AdministratorDataImpl_Stub();
			AdministratorDataService stub = (AdministratorDataService) UnicastRemoteObject.exportObject(admin, 0);
			registry.bind("administrator", stub);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
