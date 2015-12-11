package stub.businessLogicImpl_stub.managerBLImpl_stub;

import java.util.ArrayList;

import businessLogicService.managerBLService.ApprovalFormBLService;
import dataService.Approvable;
import dataService.managerDataService.ApprovalFormDataService;
import po.managerPO.UncheckedFormPO;
import stub.dataImpl_stub.managerDataImpl_stub.ApprovalFormDataImpl_Stub;
import vo.managerVO.UncheckedFormVO;

public class ApprovalFormBLImpl_Stub implements ApprovalFormBLService {
	
	private ApprovalFormDataService approvalForm = new ApprovalFormDataImpl_Stub();
	
	public UncheckedFormVO getUncheckedForms(String date) {
		UncheckedFormVO uncheckedForm = null;
		try{
			uncheckedForm = this.uncheckedFormPOTouncheckedFormVO(approvalForm.getUncheckedForms());
		}catch(Exception e){
			e.printStackTrace();
		}
		return uncheckedForm;
	}

	private UncheckedFormVO uncheckedFormPOTouncheckedFormVO(UncheckedFormPO uncheckedFormPO){
		return null;
	}

	@Override
	public UncheckedFormVO getUncheckedForms() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean approveOneForm(dataService.Approvable form, String formType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveMoreForm(ArrayList<Approvable> form, String formType) {
		// TODO Auto-generated method stub
		return false;
	}
}
