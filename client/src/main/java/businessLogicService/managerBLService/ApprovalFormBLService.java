package businessLogicService.managerBLService;

import vo.managerVO.UncheckedFormVO;

/**
 * description:业务逻辑层为审批单据界面提供的服务
 * @author 张仁知
 */
public interface ApprovalFormBLService {
	
	/**
	 * description:得到的未审批单据
	 * 前置条件：启动审批单据
	 * 后置条件：返回该日期的未审批单据
	 * 需接口：ApprovalFormDataService.getUncheckedForms()
	 * @return UncheckedFormVO , 返回未审批单据的值对象，具体参照UncheckedFormVO的定义
	 */
	public UncheckedFormVO getUncheckedForms();
}
