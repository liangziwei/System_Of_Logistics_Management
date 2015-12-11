package businessLogic.businessLogicModel.managerModel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dataService.Approvable;
import dataService.managerDataService.ApprovalFormDataService;
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
import ui.managerui.approvalformui.TableTypeName;
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
	
	private ApproveFormModel approve = new ApproveFormModel();
	
	private Map<String, Method> approvePOMap = new HashMap<String, Method>();
	
	public ApprovalForm() {
		//初始化单据名称与VO转PO方法的映射表
		try {
			//订单
			this.approvePOMap.put(TableTypeName.ORDER_NAME,
					OrderPO.class.getMethod("orderVOToPO", OrderVO.class));
			//装车单
			this.approvePOMap.put(TableTypeName.ENTRUCKING_NAME,
					EntruckingPO.class.getMethod("entrucingVOToPO", EntruckingVO.class));
			//营业厅到达单
			this.approvePOMap.put(TableTypeName.ARRIVAL_NAME, 
					ArrivalFormPO.class.getMethod("arrivalVOToPO", ArrivalFormVO.class));
			//收款单
			this.approvePOMap.put(TableTypeName.RECEIVABLE_NAME, 
					ReceivablePO.class.getMethod("receivableVOToPO", ReceivableVO.class));
			//派送单
			this.approvePOMap.put(TableTypeName.SEND_NAME,
					SendFormPO.class.getMethod("sendFormVOToPO", SendFormVO.class));
			//中转中心到达单
			this.approvePOMap.put(TableTypeName.RECEIVING_NAME,
					ReceivingPO.class.getMethod("receivingVOToPO", ReceivingVO.class));
			//入库单
			this.approvePOMap.put(TableTypeName.IN_NAME, 
					InRepositoryPO.class.getMethod("inRepositoryVOToPO", InRepositoryVO.class));
			//中转单
			this.approvePOMap.put(TableTypeName.TRANSFERRING_NAME, 
					TransferringPO.class.getMethod("transferringVOToPO", TransferringVO.class));
			//出库单
			this.approvePOMap.put(TableTypeName.OUT_NAME,
					OutRepositoryPO.class.getMethod("outRepositoryVOToPO", OutRepositoryVO.class));
			//收款单
			this.approvePOMap.put(TableTypeName.PAYMENT_NAME,
					PaymentPO.class.getMethod("paymentVOToPO", PaymentVO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *获得所有的未审批单据 
	 */
	public UncheckedFormVO getUncheckedForms() {
		UncheckedFormVO uncheckedForm = null;
		try{
			uncheckedForm = UncheckedFormPO.uncheckedFormPOToVO(approvalFormData.getUncheckedForms());
		} catch(Exception e){
			e.printStackTrace();
		}
		return uncheckedForm;
	}

	/**
	 *审批通过一张单据 
	 */
	public boolean approveOneForm(Approvable form, String formType) {
		try {
			//根据单据类型获得相应单据VO转PO的方法
			Method method = this.approvePOMap.get(formType);
			//调用方法将单据VO转成PO
			Approvable po = (Approvable) method.invoke(OrderPO.class, form);
			//根据单据类型调用相应方法更改数据库中单据的审批状态
			return this.approve.approveForm(formType, po);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 *审批通过多张单据 
	 */
	public boolean approveMoreForm(ArrayList<? extends Approvable> form, String formType) {
		int size = form.size();
		for(int i = 0; i < size; i++) {
			this.approveOneForm(form.get(i), formType);
		}
		return true;
	}
}
