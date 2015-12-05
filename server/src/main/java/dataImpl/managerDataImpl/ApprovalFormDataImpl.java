package dataImpl.managerDataImpl;

import java.rmi.RemoteException;
import java.util.List;

import dataImpl.businessDataImpl.EntruckingDataImpl;
import dataImpl.businessDataImpl.PaymentDataImpl;
import dataImpl.businessDataImpl.ReceiveAndSendDataImpl;
import dataImpl.deliveryDataImpl.OrderDataImpl;
import dataImpl.financeDataImpl.CostDataImpl;
import dataImpl.repositoryDataImpl.InRepositoryDataImpl;
import dataImpl.repositoryDataImpl.OutRepositoryDataImpl;
import dataImpl.transitionDataImpl.ReceivingDataImpl;
import dataImpl.transitionDataImpl.TransferringDataImpl;
import dataService.managerDataService.ApprovalFormDataService;
import po.businessPO.ArrivalFormPO;
import po.businessPO.EntruckingPO;
import po.businessPO.ReceivablePO;
import po.businessPO.SendFormPO;
import po.deliveryPO.OrderPO;
import po.financePO.PaymentPO;
import po.managerPO.UncheckedFormPO;
import po.repositoryPO.InRepositoryPO;
import po.repositoryPO.OutRepositoryPO;
import po.transitionPO.ReceivingPO;
import po.transitionPO.TransferringPO;
/**
 * description:数据服务层为审批单据提供服务的具体实现
 * @author 张仁知
 */

public class ApprovalFormDataImpl implements ApprovalFormDataService{
	
	private OrderDataImpl order = new OrderDataImpl();
	
	private EntruckingDataImpl entrucking = new EntruckingDataImpl();
	
	private ReceiveAndSendDataImpl recAndSend = new ReceiveAndSendDataImpl();
	
	private PaymentDataImpl receivable = new PaymentDataImpl();
	
	private ReceivingDataImpl receiving = new ReceivingDataImpl();
	
	private InRepositoryDataImpl in = new InRepositoryDataImpl();
	
	private TransferringDataImpl transferring = new TransferringDataImpl();
	
	private OutRepositoryDataImpl out = new OutRepositoryDataImpl();
	
	private CostDataImpl payment = new CostDataImpl();

	public UncheckedFormPO getUncheckedForms() throws RemoteException {
		List<OrderPO> orderList = this.order.getUncheckOrder();
		List<EntruckingPO> entruckingList = this.entrucking.getUncheckEntrucking();
		List<ArrivalFormPO> arrivalList = this.recAndSend.getUncheckArrival();
		List<ReceivablePO> receivableList = this.receivable.getUncheckReceivable();
		List<SendFormPO> sendList = this.recAndSend.getUncheckSend();
		List<ReceivingPO> receivingList = this.receiving.getUncheckReceiving();
		List<InRepositoryPO> inList = this.in.getUncheckInRepository();
		List<TransferringPO> transferringList = this.transferring.getUncheckTransferring();
		List<OutRepositoryPO> outList = this.out.getUncheckOutRepository();
		List<PaymentPO> payList = this.payment.getUncheckPayment();
		return new UncheckedFormPO(orderList, entruckingList, arrivalList, receivableList, sendList,
				receivingList, inList, transferringList, outList, payList);
	}
	
	
}
