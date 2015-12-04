package businessLogic.businessLogicModel.managerModel;

import network.RMI;
import po.managerPO.UncheckedFormPO;
import vo.managerVO.UncheckedFormVO;

import dataService.managerDataService.ApprovalFormDataService;

public class ApprovalForm {
	
	private ApprovalFormDataService approvalFormData = RMI.<ApprovalFormDataService>getDataService("approvalForm");
	
	public UncheckedFormVO getUncheckedForms() {
		UncheckedFormVO uncheckedForm = null;
		try{
			uncheckedForm = UncheckedFormPO.uncheckedFormPOToVO(approvalFormData.getUncheckedForms());
		} catch(Exception e){
			e.printStackTrace();
		}
		return uncheckedForm;
	}
}
