package businessLogicService.managerBLService;

import vo.managerVO.UncheckedFormVO;

/**
 * description:业务逻辑层为审批单据界面提供的服务
 * @author 张仁知
 */
public interface ApprovalFormBLService {
	
	/**
	 * description:通过日期得到相应的未审批单据
	 * @param date ,日期（yyyy-mm-dd）
	 * @return UncheckedFormVO , 返回未审批单据的值对象，具体参照UncheckedFormVO的定义
	 */
	
	public UncheckedFormVO getUncheckedForms(String date);

}
