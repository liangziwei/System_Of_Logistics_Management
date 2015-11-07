package businessLogic.businessLogicModel.managerModel;

import po.managerPO.UncheckedFormPO;
import vo.managerVO.UncheckedFormVO;
import mock.object.MockApprovalFormData;
import dataService.managerDataService.ApprovalFormDataService;

public class ApprovalForm {
	
	private ApprovalFormDataService approvalFormData = new MockApprovalFormData();
	
	public UncheckedFormVO getUncheckedForms(String date) {
		return this.uncheckedFormPOTouncheckedFormVO(approvalFormData.getUncheckedForms(date));
	}
	
	private UncheckedFormVO uncheckedFormPOTouncheckedFormVO(UncheckedFormPO uncheckedFormPO){
		return null;
	}
	
}
