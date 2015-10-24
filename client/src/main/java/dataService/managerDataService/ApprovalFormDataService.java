package dataService.managerDataService;

import po.managerPO.UncheckedFormPO;

/**
 * description:数据服务层为审批单据逻辑处理提供的服务
 * @author 张仁知
 */
public interface ApprovalFormDataService {


	/**
	 * description:通过日期得到相应的未审批单据
	 * @param date ,日期（yyyy-mm-dd）
	 * @return UncheckedFormPO , 返回未审批单据的值对象，具体参照UncheckedFormPO的定义
	 */
	
	public UncheckedFormPO getUncheckedForms(String date);

}
