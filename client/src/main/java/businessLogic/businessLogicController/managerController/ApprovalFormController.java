package businessLogic.businessLogicController.managerController;

import vo.ApprovalFormVO;
import vo.managerVO.UncheckedFormVO;

import java.util.ArrayList;

import businessLogic.businessLogicModel.managerModel.ApprovalForm;
import businessLogicService.managerBLService.ApprovalFormBLService;
/**
 * description:为审批单据界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class ApprovalFormController implements ApprovalFormBLService {
	
	
	private ApprovalForm approval = new ApprovalForm();
	
	public UncheckedFormVO getUncheckedForms() {
		return approval.getUncheckedForms();
	}

	@Override
	public boolean approveOneForm(ApprovalFormVO form, String formType) {
		return this.approval.approveOneForm(form, formType);
	}

	@Override
	public boolean approveMoreForm(ArrayList<ApprovalFormVO> form, String formType) {
		return this.approval.approveMoreForm(form, formType);
	}

}
