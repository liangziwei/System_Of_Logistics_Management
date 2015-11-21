package network;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.naming.ldap.ManageReferralControl;

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
import dataService.repositoryDataService.InRepositoryDataService;
import dataService.repositoryDataService.ManageRepositoryDataService;
import dataService.repositoryDataService.OutRepositoryDataService;
import dataService.senderDataService.InquireDataService;
import dataService.transitionDataService.LoadingDataService;
import dataService.transitionDataService.ReceivingDataService;
import dataService.transitionDataService.TransferringDataService;

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
		try {
			//入库单访问借口
			InRepositoryDataService inRepository = new InRepositoryDataImpl();
			InRepositoryDataService inRepository_stub = (InRepositoryDataService) UnicastRemoteObject.exportObject(inRepository,0);
			registry.bind("inrepository", inRepository_stub);
			//出库单访问借口
			OutRepositoryDataService outRepository = new OutRepositoryDataImpl();
			OutRepositoryDataService outRepository_stub = (OutRepositoryDataService) UnicastRemoteObject.exportObject(outRepository,0);
			registry.bind("outrepository", outRepository_stub);
			//库存管理访问借口
			ManageRepositoryDataService manage = new ManageRepositoryDataImpl();
			ManageRepositoryDataService manage_stub = (ManageRepositoryDataService) UnicastRemoteObject.exportObject(manage, 0);
			registry.bind("manage", manage_stub);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void initTransitionRMI() {
		try {
			//装运单访问借口
			LoadingDataService loading = new LoadingDataImpl();
			LoadingDataService loading_stub = (LoadingDataService) UnicastRemoteObject.exportObject(loading,0);
			registry.bind("loading", loading_stub);
			//接受单访问借口
			ReceivingDataService receiving = new ReceivingDataImpl();
			ReceivingDataService receiving_stub = (ReceivingDataService) UnicastRemoteObject.exportObject(receiving,0);
			registry.bind("receiving", receiving_stub);
			//中转单访问借口
			TransferringDataService transferring = new TransferringDataImpl();
			TransferringDataService transferring_stub = (TransferringDataService) UnicastRemoteObject.exportObject(transferring,0);
			registry.bind("transferring", transferring_stub);
		} catch (Exception e) {
			// TODO: handle exception
		}
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

	}

}
