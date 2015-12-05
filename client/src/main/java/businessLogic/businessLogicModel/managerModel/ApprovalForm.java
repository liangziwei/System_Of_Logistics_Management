package businessLogic.businessLogicModel.managerModel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.businessDataService.EntruckingDataService;
import dataService.businessDataService.PaymentDataService;
import dataService.businessDataService.ReceiveAndSendDataService;
import dataService.deliveryDataService.OrderDataService;
import dataService.financeDataService.CostDataService;
import dataService.managerDataService.ApprovalFormDataService;
import dataService.repositoryDataService.InRepositoryDataService;
import dataService.repositoryDataService.OutRepositoryDataService;
import dataService.transitionDataService.ReceivingDataService;
import dataService.transitionDataService.TransferringDataService;
import network.RMI;
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
import vo.ApprovalFormVO;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.EntruckingVO;
import vo.businessVO.ReceivableVO;
import vo.businessVO.SendFormVO;
import vo.deliveryVO.OrderVO;
import vo.financeVO.PaymentVO;
import vo.managerVO.UncheckedFormVO;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.ReceivingVO;
import vo.transitionVO.TransferringVO;

public class ApprovalForm {
	
	private ApprovalFormDataService approvalFormData = RMI.<ApprovalFormDataService>getDataService("approvalForm");
	
	private OrderDataService order = RMI.<OrderDataService>getDataService("order");
	
	private EntruckingDataService entrucking = RMI.<EntruckingDataService>getDataService("entrucking");
	
	private PaymentDataService receivable = RMI.<PaymentDataService>getDataService("receivable");
	
	private ReceiveAndSendDataService recAndSend = RMI.<ReceiveAndSendDataService>getDataService("receiveAndSend");
	
	private ReceivingDataService receiving = RMI.<ReceivingDataService>getDataService("receiving");
	
	private InRepositoryDataService in = RMI.<InRepositoryDataService>getDataService("inrepository");
	
	private TransferringDataService transferring = RMI.<TransferringDataService>getDataService("transferring");
	
	private OutRepositoryDataService out = RMI.<OutRepositoryDataService>getDataService("outrepository");
	
	private CostDataService payment = RMI.<CostDataService>getDataService("cost");
	
	public UncheckedFormVO getUncheckedForms() {
		UncheckedFormVO uncheckedForm = null;
		try{
			uncheckedForm = UncheckedFormPO.uncheckedFormPOToVO(approvalFormData.getUncheckedForms());
		} catch(Exception e){
			e.printStackTrace();
		}
		return uncheckedForm;
	}

	public boolean approveOneForm(ApprovalFormVO form, String formType) {
		switch(formType) {
		case "寄件单":
			try {
				return this.order.approveOneOrder(OrderPO.orderVOToPO((OrderVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "装车单":
			try {
				return this.entrucking.approveOneEntrucking(EntruckingPO.entrucingVOToPO((EntruckingVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "收款单":
			try {
				return this.receivable.approveOneReceivable(ReceivablePO.ReceiptVOToPO((ReceivableVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "营业厅到达单":
			try {
				return this.recAndSend.approveOneArrivalForm(ArrivalFormPO.arrivalVOToPO((ArrivalFormVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "派件单":
			try {
				this.recAndSend.approveOneSendForm(SendFormPO.sendFormVOToPO((SendFormVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "中转中心到达单":
			try {
				return this.receiving.approveOneReceiving(ReceivingPO.receivingVOToPO((ReceivingVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "入库单":
			try {
				return this.in.approveOneInRepository(InRepositoryPO.inRepositoryVOToPO((InRepositoryVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "中转单":
			try {
				return this.transferring.approveOneTransferring(TransferringPO.transferringVOToPO((TransferringVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "出库单":
			try {
				return this.out.approveOneOutRepository(OutRepositoryPO.outRepositoryVOToPO((OutRepositoryVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "付款单":
			try {
				return this.payment.approveOnePayment(PaymentPO.paymentVOToPO((PaymentVO) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean approveMoreForm(ArrayList<? extends ApprovalFormVO> form, String formType) {
		switch(formType) {
		case "寄件单":
			try {
				return this.order.approveMoreOrder
						(OrderPO.orderVOListToPO((ArrayList<OrderVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "装车单":
			try {
				return this.entrucking.approveMoreEntrucking
						(EntruckingPO.entruckingVOListToPO((ArrayList<EntruckingVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "收款单":
			try {
				return this.receivable.approveMoreReceivable
						(ReceivablePO.receivableVOListToPO((ArrayList<ReceivableVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "营业厅到达单":
			try {
				return this.recAndSend.approveMoreArrivalForm
						(ArrivalFormPO.arrivalVOListToPO((ArrayList<ArrivalFormVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "派件单":
			try {
				return this.recAndSend.approveMoreSendForm
				(SendFormPO.senFormVOListToPO((ArrayList<SendFormVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "中转中心到达单":
			try {
				return this.receiving.approveMoreReceiving
						(ReceivingPO.receivingVOListToPO((ArrayList<ReceivingVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "入库单":
			try {
				return this.in.approveMoreInRepository
						(InRepositoryPO.inRepositoryVOListToPO((ArrayList<InRepositoryVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "中转单":
			try {
				return this.transferring.approveMoreTransferring
						(TransferringPO.transferringVOListToPO((ArrayList<TransferringVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "出库单":
			try {
				return this.out.approveMoreOutRepository
						(OutRepositoryPO.outRepositoryVOListToPO((ArrayList<OutRepositoryVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		case "付款单":
			try {
				return this.payment.approveMorePayment
						(PaymentPO.paymentVOListToPO((ArrayList<PaymentVO>) form));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
