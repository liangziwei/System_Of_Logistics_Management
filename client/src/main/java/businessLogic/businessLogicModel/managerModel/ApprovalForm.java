package businessLogic.businessLogicModel.managerModel;



import network.RMI;
import po.managerPO.UncheckedFormPO;
import vo.managerVO.UncheckedFormVO;

import dataService.managerDataService.ApprovalFormDataService;

public class ApprovalForm {
	
	private ApprovalFormDataService approvalFormData = RMI.<ApprovalFormDataService>getDataService("approvalForm");
	
	public UncheckedFormVO getUncheckedForms(String date) {
		UncheckedFormVO uncheckedForm = null;
		try{
			uncheckedForm = this.uncheckedFormPOTouncheckedFormVO(approvalFormData.getUncheckedForms(date));
		} catch(Exception e){
			e.printStackTrace();
		}
		return uncheckedForm;
	}
	
	private UncheckedFormVO uncheckedFormPOTouncheckedFormVO(UncheckedFormPO uncheckedFormPO){
		return null;
	}
	
}
