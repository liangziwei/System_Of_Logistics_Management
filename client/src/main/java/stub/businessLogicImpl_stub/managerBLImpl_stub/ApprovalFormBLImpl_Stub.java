package stub.businessLogicImpl_stub.managerBLImpl_stub;

import po.managerPO.UncheckedFormPO;
import stub.dataImpl_stub.managerDataImpl_stub.ApprovalFormDataImpl_Stub;
import vo.managerVO.UncheckedFormVO;
import businessLogicService.managerBLService.ApprovalFormBLService;
import dataService.managerDataService.ApprovalFormDataService;

public class ApprovalFormBLImpl_Stub implements ApprovalFormBLService {
	
	private ApprovalFormDataService approvalForm = new ApprovalFormDataImpl_Stub();
	
	public UncheckedFormVO getUncheckedForms(String date) {
		UncheckedFormVO uncheckedForm = null;
		try{
			uncheckedForm = this.uncheckedFormPOTouncheckedFormVO(approvalForm.getUncheckedForms(date));
		}catch(Exception e){
			e.printStackTrace();
		}
		return uncheckedForm;
	}

	private UncheckedFormVO uncheckedFormPOTouncheckedFormVO(UncheckedFormPO uncheckedFormPO){
		return null;
	}
}
