package businessLogic.businessLogicController.managerController;

import vo.managerVO.UncheckedFormVO;
import businessLogic.businessLogicModel.managerModel.ApprovalForm;
import businessLogicService.managerBLService.ApprovalFormBLService;
/**
 * description:为审批单据界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class ApprovalFormController implements ApprovalFormBLService {
	
	
	private ApprovalForm approval = new ApprovalForm();
	
	public UncheckedFormVO getUncheckedForms(String date) {
		return approval.getUncheckedForms(date);
	}

}
