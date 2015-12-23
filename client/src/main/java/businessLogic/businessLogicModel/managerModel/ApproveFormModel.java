package businessLogic.businessLogicModel.managerModel;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import dataService.Approvable;
import dataService.ApproveFormService;
import dataService.businessDataService.EntruckingDataService;
import dataService.businessDataService.PaymentDataService;
import dataService.businessDataService.ReceiveAndSendDataService;
import dataService.deliveryDataService.OrderDataService;
import dataService.financeDataService.CostDataService;
import dataService.repositoryDataService.InRepositoryDataService;
import dataService.repositoryDataService.OutRepositoryDataService;
import dataService.transitionDataService.ReceivingDataService;
import dataService.transitionDataService.TransferringDataService;
import network.RMI;
import ui.managerui.approvalformui.TableTypeName;

/**
 *审批单据方法的实现 
 */
public class ApproveFormModel {
	
	private OrderDataService order = RMI.<OrderDataService>getDataService("order");
	
	private EntruckingDataService entrucking = RMI.<EntruckingDataService>getDataService("entrucking");
	
	private PaymentDataService receivable = RMI.<PaymentDataService>getDataService("receivable");
	
	private ReceiveAndSendDataService recAndSend = RMI.<ReceiveAndSendDataService>getDataService("receiveAndSend");
	
	private ReceivingDataService receiving = RMI.<ReceivingDataService>getDataService("receiving");
	
	private InRepositoryDataService in = RMI.<InRepositoryDataService>getDataService("inrepository");
	
	private TransferringDataService transferring = RMI.<TransferringDataService>getDataService("transferring");
	
	private OutRepositoryDataService out = RMI.<OutRepositoryDataService>getDataService("outrepository");
	
	private CostDataService payment = RMI.<CostDataService>getDataService("cost");
	
	private Map<String, ApproveFormService> serviceMap = new HashMap<String, ApproveFormService>();
	
	public ApproveFormModel() {
		//初始化单据名称与对应的数据接口的映射表
		this.serviceMap.put(TableTypeName.ORDER_NAME, this.order);
		this.serviceMap.put(TableTypeName.ENTRUCKING_NAME, this.entrucking);
		this.serviceMap.put(TableTypeName.RECEIVABLE_NAME, this.receivable);
		this.serviceMap.put(TableTypeName.ARRIVAL_NAME, this.recAndSend);
		this.serviceMap.put(TableTypeName.SEND_NAME, this.recAndSend);
		this.serviceMap.put(TableTypeName.RECEIVING_NAME, this.receiving);
		this.serviceMap.put(TableTypeName.IN_NAME, this.in);
		this.serviceMap.put(TableTypeName.TRANSFERRING_NAME, this.transferring);
		this.serviceMap.put(TableTypeName.OUT_NAME, this.out);
		this.serviceMap.put(TableTypeName.PAYMENT_NAME, this.payment);
	}

	/**
	 *根据单据名称将相应的单据在数据库中的审批状态改变 
	 */
	public boolean approveForm(String formType, Approvable form) {
		try {
			return this.serviceMap.get(formType).ApproveOneForm(form);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
